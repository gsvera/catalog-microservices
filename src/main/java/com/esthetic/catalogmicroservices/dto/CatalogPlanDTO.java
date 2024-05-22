package com.esthetic.catalogmicroservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogPlanDTO {
    private int id;
    private String name;
    private String descriptionEs;
    private String descriptionEn;
    private double price;
    private int duration;
    private int active;
    private List<CatalogPlanDetailDTO> planDetails;

}
