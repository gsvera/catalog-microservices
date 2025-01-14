package com.esthetic.catalogmicroservices.dto;

import com.esthetic.catalogmicroservices.entity.CatalogUserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogUserServiceDTO {
    private int id;
    private String idUser;
    private int idService;
    private double minPrice;
    private double maxPrice;

    public CatalogUserServiceDTO(CatalogUserService catalogUserService) {
        this.id = catalogUserService.getId();
        this.idService = catalogUserService.getIdService();
        this.minPrice = catalogUserService.getMinPrice();
        this.maxPrice = catalogUserService.getMaxPrice();
    }
}