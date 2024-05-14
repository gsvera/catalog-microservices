package com.esthetic.catalogmicroservices.service;

import com.esthetic.catalogmicroservices.dto.CatalogPlanDTO;
import com.esthetic.catalogmicroservices.dto.CatalogPlanDetailDTO;
import com.esthetic.catalogmicroservices.entity.CatalogPlan;
import com.esthetic.catalogmicroservices.entity.CatalogPlanDetail;
import com.esthetic.catalogmicroservices.repository.CatalogPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogPlanService {
    private final CatalogPlanRepository catalogPlanRepository;
    public CatalogPlanService(CatalogPlanRepository catalogPlanRepository) {
        this.catalogPlanRepository = catalogPlanRepository;
    }

    public List<CatalogPlanDTO> getAllPlan() {
        List<CatalogPlan> catalogPlans = catalogPlanRepository.findAll();
        return catalogPlans.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public CatalogPlanDTO convertToDto(CatalogPlan catalogPlan){
        List<CatalogPlanDetailDTO> detailDTOS = catalogPlan.getPlanDetails().stream()
                .map(this::convertDetailToDTO)
                .collect(Collectors.toList());
        return new CatalogPlanDTO(
                catalogPlan.getId(),
                catalogPlan.getName(),
                catalogPlan.getDescription(),
                catalogPlan.getPrice(),
                catalogPlan.getActive(),
                detailDTOS
        );
    }

    public CatalogPlanDetailDTO convertDetailToDTO(CatalogPlanDetail detail) {
        return new CatalogPlanDetailDTO(
                detail.getId(),
                detail.getCatalogPlan().getId(),
                detail.getDescriptionEs(),
                detail.getDescriptionEn()
        );
    }
}
