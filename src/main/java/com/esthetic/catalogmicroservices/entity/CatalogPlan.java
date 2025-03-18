package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tbl_catalog_plan")
public class CatalogPlan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "description_es")
    private String descriptionEs;
    @Column(name = "description_en")
    private String descriptionEn;
    private double price;
    private int duration;
    private Boolean active;
    @OneToMany(mappedBy = "catalogPlan")
    private List<CatalogPlanDetail> planDetails;
}
