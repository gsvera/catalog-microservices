package com.esthetic.catalogmicroservices.service;

import com.esthetic.catalogmicroservices.dto.CatalogStatusDTO;
import com.esthetic.catalogmicroservices.entity.CatalogStatus;
import com.esthetic.catalogmicroservices.repository.CatalogStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatalogStatusService {
    private final CatalogStatusRepository catalogStatusRepository;

    public CatalogStatusService(CatalogStatusRepository catalogStatusRepository) {
        this.catalogStatusRepository = catalogStatusRepository;
    }

    public List<CatalogStatusDTO> getAllCatalogStatus() {
        List<CatalogStatus> catalogStatus = catalogStatusRepository.findAll();
        return catalogStatus.stream().map(item -> new CatalogStatusDTO(
                item.getId(),
                item.getNumberOrder(),
                item.getStatusNameEs(),
                item.getStatusNameEn(),
                item.getStatusNamePt(),
                item.getDescriptionEs(),
                item.getDescriptionEn(),
                item.getDescriptionPt(),
                item.getBackgroundColor(),
                item.getFontColor()
        )).collect(Collectors.toList());
    }
    public CatalogStatusDTO getById(Long id) {
        Optional<CatalogStatus> catalogStatus = catalogStatusRepository.findById(id);
        return new CatalogStatusDTO(
                catalogStatus.get().getId(),
                catalogStatus.get().getNumberOrder(),
                catalogStatus.get().getStatusNameEs(),
                catalogStatus.get().getStatusNameEs(),
                catalogStatus.get().getStatusNamePt(),
                catalogStatus.get().getDescriptionEs(),
                catalogStatus.get().getDescriptionEn(),
                catalogStatus.get().getDescriptionPt(),
                catalogStatus.get().getBackgroundColor(),
                catalogStatus.get().getFontColor());
    }

    public CatalogStatusDTO getByName(String name) {
        CatalogStatus catalogStatus = catalogStatusRepository.findByStatusNameEs(name);
        return new CatalogStatusDTO(catalogStatus.getStatusNameEs(), catalogStatus.getStatusNameEn(), catalogStatus.getStatusNamePt());
    }
}
