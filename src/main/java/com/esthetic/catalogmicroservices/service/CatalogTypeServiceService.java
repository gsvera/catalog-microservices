package com.esthetic.catalogmicroservices.service;

import com.esthetic.catalogmicroservices.dto.CatalogTypeServiceDTO;
import com.esthetic.catalogmicroservices.entity.CatalogTypeService;
import com.esthetic.catalogmicroservices.repository.CatalogTypeServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatalogTypeServiceService {
    private final CatalogTypeServiceRepository catalogTypeServiceRepository;

    public CatalogTypeServiceService(CatalogTypeServiceRepository catalogTypeServiceRepository) {
        this.catalogTypeServiceRepository = catalogTypeServiceRepository;
    }

    public List<CatalogTypeServiceDTO> getAllCatalogTypeService() {
        List<CatalogTypeService> catalogTypeService = catalogTypeServiceRepository.findAll();
        return catalogTypeService.stream().map(item -> new CatalogTypeServiceDTO(
                item.getId(),
                item.getTypeServiceNameEs(),
                item.getTypeServiceNameEn(),
                item.getTypeServiceNamePt(),
                item.getDescriptionEs(),
                item.getDescriptionEn(),
                item.getDescriptionPt(),
                item.getIcon(),
                item.getAcronym()
        )).collect(Collectors.toList());
    }
    public CatalogTypeServiceDTO getById(Long id) {
        Optional<CatalogTypeService> catalogTypeService = catalogTypeServiceRepository.findById(id);
        return new CatalogTypeServiceDTO(
                catalogTypeService.get().getId(),
                catalogTypeService.get().getTypeServiceNameEs(),
                catalogTypeService.get().getTypeServiceNameEn(),
                catalogTypeService.get().getTypeServiceNamePt(),
                catalogTypeService.get().getDescriptionEs(),
                catalogTypeService.get().getDescriptionEn(),
                catalogTypeService.get().getDescriptionPt(),
                catalogTypeService.get().getIcon(),
                catalogTypeService.get().getAcronym());
    }
}
