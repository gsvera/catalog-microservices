package com.esthetic.catalogmicroservices.service;

import com.esthetic.catalogmicroservices.dto.CatalogGeoMunicipalityDTO;
import com.esthetic.catalogmicroservices.dto.CatalogGeoStateDTO;
import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.entity.CatalogGeoMunicipality;
import com.esthetic.catalogmicroservices.repository.CatalogGeoMunicipalityRepository;
import com.esthetic.catalogmicroservices.repository.CatalogGeoStateRepository;
import com.esthetic.catalogmicroservices.utils.ApiHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogService {
    private final CatalogGeoStateRepository catalogGeoStateRepository;
    private final CatalogGeoMunicipalityRepository catalogGeoMunicipalityRepository;
    private final ApiHelper apiHelper;
    public ResponseDTO _GetCatalogGeoState() {
        return ResponseDTO.builder().items(
                catalogGeoStateRepository.findAll().stream().map(item -> new CatalogGeoStateDTO(item)).collect(Collectors.toList())
        ).build();
    }
    public ResponseDTO _GetMunicipalityByState(Long idState) {
        return ResponseDTO.builder().items(
                catalogGeoMunicipalityRepository.findByStateId(idState).stream().map(item -> new CatalogGeoMunicipalityDTO(item)).collect(Collectors.toList())
        ).build();
    }
    public void _UpdateMunicipality() throws JsonProcessingException {
        List<Object[]> municipality = catalogGeoMunicipalityRepository.findEmpty();
        for(Object[] row : municipality) {
            HttpHeaders headers = new HttpHeaders();
            HttpEntity httpEntity = new HttpEntity<>(headers);
            String apiUrl = "https://nominatim.openstreetmap.org/search?state="+row[1]+"&city="+row[2]+"&country=Mexico&format=json";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseApi = restTemplate.exchange(apiUrl, HttpMethod.GET,httpEntity, String.class);
            Optional<CatalogGeoMunicipality> catalogGeoMunicipality = catalogGeoMunicipalityRepository.findById((Long)row[0]);
            if(responseApi.getStatusCode().is2xxSuccessful()) {
                ObjectMapper mapper = new ObjectMapper();
                System.out.println(responseApi.getBody());
                JsonNode root = mapper.readTree(responseApi.getBody());
                if (root.isArray() && root.size() > 0) {
                    JsonNode first = root.get(0);
                    Double lat = first.get("lat").asDouble();
                    Double lon = first.get("lon").asDouble();
                    System.out.println("Lat: " + lat + ", Lon: " + lon);

                    if(catalogGeoMunicipality.isPresent()) {
                        catalogGeoMunicipality.orElseThrow().setLatitude(lat);
                        catalogGeoMunicipality.orElseThrow().setLongitude(lon);

                    }
                } else {
                    catalogGeoMunicipality.orElseThrow().setLatitude(0.0);
                    catalogGeoMunicipality.orElseThrow().setLongitude(0.0);
                }
                catalogGeoMunicipalityRepository.save(catalogGeoMunicipality.get());
            }
        }
    }
}
