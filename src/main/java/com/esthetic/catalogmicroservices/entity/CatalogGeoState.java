package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_catalog_geo_state")
public class CatalogGeoState {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "state_name")
    public String stateName;
}
