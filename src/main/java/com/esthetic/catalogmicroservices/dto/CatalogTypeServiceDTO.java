package com.esthetic.catalogmicroservices.dto;

import com.esthetic.catalogmicroservices.entity.CatalogTypeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatalogTypeServiceDTO {
    private Long id;
    private String typeServiceNameEs;
    private String typeServiceNameEn;
    private String descriptionEs;
    private String descriptionEn;
    private String icon;
    private String acronym;
    public CatalogTypeServiceDTO(CatalogTypeService catalogTypeService) {
        this.id = catalogTypeService.getId();
        this.typeServiceNameEs = catalogTypeService.getTypeServiceNameEs();
        this.typeServiceNameEn = catalogTypeService.getTypeServiceNameEn();
        this.descriptionEs = catalogTypeService.getDescriptionEs();
        this.descriptionEn = catalogTypeService.getDescriptionEn();
        this.icon = catalogTypeService.getIcon();
        this.acronym = catalogTypeService.getAcronym();
    }
}
