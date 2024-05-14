package com.esthetic.catalogmicroservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogPlanDetailDTO {
    private int id;
    private int idPlan;
    private String descriptionEs;
    private String descriptionEn;

}
