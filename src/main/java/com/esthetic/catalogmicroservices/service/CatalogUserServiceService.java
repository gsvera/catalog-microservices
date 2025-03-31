package com.esthetic.catalogmicroservices.service;

import com.esthetic.catalogmicroservices.dto.CatalogUserServiceDTO;
import com.esthetic.catalogmicroservices.dto.CatalogUserServiceDetailDTO;
import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.entity.CatalogUserService;
import com.esthetic.catalogmicroservices.entity.CatalogUserServiceDetail;
import com.esthetic.catalogmicroservices.repository.CatalogUserServiceDetailRepository;
import com.esthetic.catalogmicroservices.repository.CatalogUserServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CatalogUserServiceService {
    private final CatalogUserServiceRepository catalogUserServiceRepository;
    private final CatalogUserServiceDetailRepository catalogUserServiceDetailRepository;

    public ResponseDTO _SaveCatalogService(CatalogUserServiceDTO catalogUserServiceDTO ){
        CatalogUserService newCatalogUserService = new CatalogUserService(catalogUserServiceDTO);
        catalogUserServiceRepository.save(newCatalogUserService);
        for(CatalogUserServiceDetailDTO items : catalogUserServiceDTO.items) {
            items.idUserCatalogService = newCatalogUserService.getId();
            catalogUserServiceDetailRepository.save(new CatalogUserServiceDetail(items));
        }
        return ResponseDTO.builder().message("Registro guardado con éxito").build();
    }
    public ResponseDTO _GetByUser(String idUser) {
        List<Object[]> list = catalogUserServiceRepository.findAllByIdUser(idUser);
        List<CatalogUserServiceDTO> listCatalog = new ArrayList<>();
        for(Object[] row : list) {
            CatalogUserServiceDTO catalogUserServiceDTO = new CatalogUserServiceDTO();
            CatalogUserServiceDetailDTO catalogUserServiceDetailDTO = new CatalogUserServiceDetailDTO();
            catalogUserServiceDTO.id = (Long)row[0];
            catalogUserServiceDTO.nameService = (String)row[1];
            catalogUserServiceDTO.minPrice = (double) row[2];
            catalogUserServiceDTO.maxPrice = (double) row[3];
            catalogUserServiceDetailDTO.id = (Long) row[4];
            catalogUserServiceDetailDTO.fileBase64 = (String)row[5];
            catalogUserServiceDTO.totalElement = row[6] != null ? ((Number) row[6]).intValue() : 0;
            catalogUserServiceDTO.catalogUserServiceDetailDTO = catalogUserServiceDetailDTO;
            listCatalog.add(catalogUserServiceDTO);
        }
        return ResponseDTO.builder().items(listCatalog).build();
    }
    public ResponseDTO _DeleteCatalogServiceById(Long idCatalog) {
        List<CatalogUserServiceDetail> list = catalogUserServiceDetailRepository.findByIdUserCatalogServiceToDelete(idCatalog);
        if(list.size() > 0) {
            catalogUserServiceDetailRepository.deleteAll(list);
        }
        Optional<CatalogUserService> catalogUserService = catalogUserServiceRepository.findById(idCatalog);
        if(catalogUserService.isPresent()) {
            catalogUserServiceRepository.delete(catalogUserService.get());
        }
        return ResponseDTO.builder().message("Registro eliminado con éxito").build();
    }
}
