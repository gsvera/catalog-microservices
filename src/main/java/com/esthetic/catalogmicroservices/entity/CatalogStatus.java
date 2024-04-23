package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "tbl_catalog_status")
@Entity
@ToString
public class CatalogStatus {
    @Id @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Column(name = "number_order")
    private int numberOrder;
    @Getter @Column(name = "status_name_es")
    private String statusNameEs;
    @Getter @Column(name = "status_name_en")
    private String statusNameEn;
    @Getter @Column(name = "status_name_pt")
    private String statusNamePt;
    @Getter @Column(name = "description_es")
    private String descriptionEs;
    @Getter @Column(name = "description_en")
    private String descriptionEn;
    @Getter @Column(name = "description_pt")
    private String descriptionPt;
    @Getter @Column(name = "background_color")
    private String backgroundColor;
    @Getter @Column(name = "font_color")
    private String fontColor;
}
