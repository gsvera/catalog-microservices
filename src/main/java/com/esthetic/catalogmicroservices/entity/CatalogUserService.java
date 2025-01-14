package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_user_catalog_service")
@NoArgsConstructor
@AllArgsConstructor
public class CatalogUserService {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_user")
    private String idUser;
    @Column(name = "id_service")
    private int idService;
    @Column(name = "min_price")
    private double minPrice;
    @Column(name = "max_price")
    private double maxPrice;
}
