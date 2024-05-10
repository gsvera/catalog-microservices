package com.esthetic.catalogmicroservices.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CatalogProfileDTO {
    @Id
    @Getter
    private Long id;
    @Getter
    private String profileNameEs;
    @Getter
    private String profileNameEn;
    @Getter
    private String descriptionEs;
    @Getter
    private String descriptionEn;
}
