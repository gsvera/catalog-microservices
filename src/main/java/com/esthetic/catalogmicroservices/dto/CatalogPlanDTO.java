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
    private String description;
    private double price;
    private int active;
    private List<CatalogPlanDetailDTO> planDetails;

}
