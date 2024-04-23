package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "tbl_catalog_type_service")
@ToString
public class CatalogTypeService {
    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Column(name = "type_service_name_es")
    private String typeServiceNameEs;
    @Getter @Column(name = "type_service_name_en")
    private String typeServiceNameEn;
    @Getter @Column(name = "type_service_name_pt")
    private String typeServiceNamePt;
    @Getter @Column(name = "description_es")
    private String descriptionEs;
    @Getter @Column(name = "description_en")
    private String descriptionEn;
    @Getter @Column(name = "description_pt")
    private String descriptionPt;
    @Getter
    private String icon;
    @Getter
    private String acronym;
}
