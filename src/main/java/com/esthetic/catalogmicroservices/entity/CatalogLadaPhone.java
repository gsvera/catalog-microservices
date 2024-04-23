package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "tbl_catalog_lada_phone")
@ToString
public class CatalogLadaPhone {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String code;

    @Getter
    private String lada;

    @Getter
    private String lang;
    @Getter
    @Column(name = "country_es")
    private String countryEs;

    @Getter
    @Column(name = "country_en")
    private String countryEn;
}
