package com.esthetic.catalogmicroservices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class CatalogStatusDTO {
    @Getter
    private Long id;
    @Getter
    private int numberOrder;
    @Getter
    private String statusNameEs;
    @Getter
    private String statusNameEn;
    @Getter
    private String statusNamePt;
    @Getter
    private String descriptionEs;
    @Getter
    private String descriptionEn;
    @Getter
    private String descriptionPt;
    @Getter
    private String backgroundColor;
    @Getter
    private String fontColor;

    public CatalogStatusDTO(String statusNameEs, String statusNameEn, String statusNamePt) {
        this.statusNameEs = statusNameEs;
        this.statusNameEn = statusNameEn;
        this.statusNamePt = statusNamePt;
    }
}
