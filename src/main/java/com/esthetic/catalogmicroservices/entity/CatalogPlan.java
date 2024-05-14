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
    private String description;
    private double price;
    private int active;
    @OneToMany(mappedBy = "catalogPlan")
    private List<CatalogPlanDetail> planDetails;
}
