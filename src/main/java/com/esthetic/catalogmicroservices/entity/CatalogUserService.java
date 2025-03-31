package com.esthetic.catalogmicroservices.entity;

import com.esthetic.catalogmicroservices.dto.CatalogUserServiceDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbl_user_catalog_service")
@AllArgsConstructor
@NoArgsConstructor
public class CatalogUserService {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_user")
    private String idUser;
    @Column(name = "name_service")
    private String nameService;
    @Column(name = "min_price")
    private double minPrice;
    @Column(name = "max_price")
    private double maxPrice;
    public CatalogUserService (CatalogUserServiceDTO catalogUserServiceDTO) {
        this.idUser = catalogUserServiceDTO.idUser;
        this.nameService = catalogUserServiceDTO.nameService;
        this.minPrice = catalogUserServiceDTO.minPrice;
        this.maxPrice = catalogUserServiceDTO.maxPrice;
    }
}
