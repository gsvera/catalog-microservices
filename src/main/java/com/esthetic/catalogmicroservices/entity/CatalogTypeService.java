package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "tbl_catalog_type_service")
@ToString
@Data
public class CatalogTypeService {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type_service_name_es")
    private String typeServiceNameEs;
    @Column(name = "type_service_name_en")
    private String typeServiceNameEn;
    @Column(name = "description_es")
    private String descriptionEs;
    @Column(name = "description_en")
    private String descriptionEn;
    private String icon;
    private String acronym;
}
