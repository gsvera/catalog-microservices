package com.esthetic.catalogmicroservices.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatalogProfileDTO {
    private Long id;
    private String profileNameEs;
    private String profileNameEn;
    private String descriptionEs;
    private String descriptionEn;
    private boolean withPlan;
}
