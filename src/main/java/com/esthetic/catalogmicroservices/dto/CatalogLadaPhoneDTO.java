package com.esthetic.catalogmicroservices.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CatalogLadaPhoneDTO {
    @Id
    @Getter
    private Long id;

    @Getter
    private String code;
    @Getter
    private String lada;
    @Getter
    private String lang;
    @Getter
    private String countryEs;
    @Getter
    private String countryEn;
}
