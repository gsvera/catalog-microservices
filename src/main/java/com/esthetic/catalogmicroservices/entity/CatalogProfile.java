package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "tbl_catalog_profile")
@ToString
public class CatalogProfile {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Column(name = "profile_name_es")
    private String profileNameEs;
    @Getter
    @Column(name = "profile_name_en")
    private String profileNameEn;
    @Getter
    private String description;
}
