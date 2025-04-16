package com.esthetic.catalogmicroservices.service;

import com.esthetic.catalogmicroservices.dto.CatalogTypeServiceDTO;
import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.dto.TypeServiceXUserDTO;
import com.esthetic.catalogmicroservices.entity.CatalogTypeService;
import com.esthetic.catalogmicroservices.entity.TypeServiceXUser;
import com.esthetic.catalogmicroservices.repository.CatalogTypeServiceRepository;
import com.esthetic.catalogmicroservices.repository.TypeServiceXUserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatalogTypeServiceService {
    private final CatalogTypeServiceRepository catalogTypeServiceRepository;
    private final TypeServiceXUserRepository typeServiceXUserRepository;

    public CatalogTypeServiceService(CatalogTypeServiceRepository catalogTypeServiceRepository, TypeServiceXUserRepository typeServiceXUserRepository) {
        this.catalogTypeServiceRepository = catalogTypeServiceRepository;
        this.typeServiceXUserRepository = typeServiceXUserRepository;
    }

    public List<CatalogTypeServiceDTO> getAllCatalogTypeService() {
        List<CatalogTypeService> catalogTypeService = catalogTypeServiceRepository.findAllisActive();
        return catalogTypeService.stream().map(item -> new CatalogTypeServiceDTO(item)).collect(Collectors.toList());
    }
    public CatalogTypeServiceDTO getById(Long id) {
        Optional<CatalogTypeService> catalogTypeService = catalogTypeServiceRepository.findById(id);
        return new CatalogTypeServiceDTO(catalogTypeService.get());
    }

    public ResponseDTO _GetTypeServiceByUser(String idUser) {
        List<TypeServiceXUser> list = typeServiceXUserRepository.findByIdUser(idUser);
        List<TypeServiceXUserDTO> listType = list.stream().map(item -> new TypeServiceXUserDTO(item)).collect(Collectors.toList());
        Map<String, Object> response = new HashMap<>();
        response.put("listType", listType);
        return ResponseDTO.builder().items(response).build();
    }
    public ResponseDTO _SaveTypeServiceByUser(String idUser, List<Long> ids) {
        this._DeleteTypeServiceXUser(idUser);
        for(Long id : ids) {
            TypeServiceXUser typeServiceXUser = new TypeServiceXUser(idUser, id);
            typeServiceXUserRepository.save(typeServiceXUser);
        }

        return ResponseDTO.builder().message("Registros guardados con éxito").build();
    }
    public void _DeleteTypeServiceXUser(String idUser) {
        List<TypeServiceXUser> list = typeServiceXUserRepository.findByIdUser(idUser);
        if(list.size() > 0) {
            typeServiceXUserRepository.deleteAll(list);
        }
    }
}
