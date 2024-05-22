package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "tbl_catalog_profile")
@ToString
@Data
public class CatalogProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "profile_name_es")
    private String profileNameEs;
    @Column(name = "profile_name_en")
    private String profileNameEn;
    @Column(name = "description_es")
    private String descriptionEs;
    @Column(name = "description_en")
    private String descriptionEn;
    @Column(name = "with_plan")
    private boolean withPlan;
}
