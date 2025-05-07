package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_catalog_geo_municipality")
public class CatalogGeoMunicipality {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "state_id")
    private Long stateId;
    @Column(name = "municipality_name")
    private String municipalityName;
    private Double latitude;
    private Double longitude;

}
