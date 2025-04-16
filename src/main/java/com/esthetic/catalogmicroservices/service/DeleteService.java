package com.esthetic.catalogmicroservices.service;

import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.entity.CatalogUserService;
import com.esthetic.catalogmicroservices.repository.CatalogUserServiceDetailRepository;
import com.esthetic.catalogmicroservices.repository.CatalogUserServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeleteService {
    private final CatalogUserServiceRepository catalogUserServiceRepository;
    private final CatalogUserServiceDetailRepository catalogUserServiceDetailRepository;
    private final CatalogTypeServiceService catalogTypeServiceService;
    public ResponseDTO _DeleteAllCatalogsByUser(String idUser) {
        List<CatalogUserService> listCatalog = catalogUserServiceRepository.findByIdUser(idUser);
        for(CatalogUserService item : listCatalog) {
            catalogUserServiceDetailRepository.deleteDetailByUserCatalogService(item.getId());
            catalogUserServiceRepository.deleteById(item.getId());
        }
        catalogTypeServiceService._DeleteTypeServiceXUser(idUser);
        return ResponseDTO.builder().message("Registros eliminados").build();
    }
}
