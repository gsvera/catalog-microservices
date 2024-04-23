package com.esthetic.catalogmicroservices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CatalogTypeServiceDTO {
    @Getter
    private Long id;
    @Getter
    private String typeServiceNameEs;
    @Getter
    private String typeServiceNameEn;
    @Getter
    private String typeServiceNamePt;
    @Getter
    private String descriptionEs;
    @Getter
    private String descriptionEn;
    @Getter
    private String descriptionPt;
    @Getter
    private String icon;
    @Getter
    private String acronym;
}
