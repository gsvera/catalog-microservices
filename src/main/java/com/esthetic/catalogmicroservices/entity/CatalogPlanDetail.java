package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_catalog_plan_detail")
public class CatalogPlanDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "description_es")
    private String descriptionEs;
    @Column(name = "description_en")
    private String descriptionEn;
    @ManyToOne
    @JoinColumn(name = "id_plan")
    private CatalogPlan catalogPlan;
}
