package com.esthetic.catalogmicroservices.dto;

import com.esthetic.catalogmicroservices.entity.CatalogUserService;
import com.esthetic.catalogmicroservices.entity.CatalogUserServiceDetail;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class CatalogUserServiceDTO {
    public Long id;
    public String idUser;
    public String nameService;
    public double minPrice;
    public double maxPrice;
    public CatalogUserServiceDetailDTO catalogUserServiceDetailDTO;
    public List<CatalogUserServiceDetailDTO> items;
    public int totalElement;

    public CatalogUserServiceDTO(CatalogUserService catalogUserService) {
        this.id = catalogUserService.getId();
        this.idUser = catalogUserService.getIdUser();
        this.nameService = catalogUserService.getNameService();
        this.minPrice = catalogUserService.getMinPrice();
        this.maxPrice = catalogUserService.getMaxPrice();
    }
    public CatalogUserServiceDTO(Long id, String nameService, double minPrice, double maxPrice, CatalogUserServiceDetail catalogUserServiceDetail) {
        this.id = id;
        this.nameService = nameService;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;

        if(catalogUserServiceDetail != null) {
            this.catalogUserServiceDetailDTO = new CatalogUserServiceDetailDTO(catalogUserServiceDetail);
        }
    }
}
