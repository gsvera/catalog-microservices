package com.esthetic.catalogmicroservices.dto;

import com.esthetic.catalogmicroservices.entity.CatalogUserService;
import com.esthetic.catalogmicroservices.entity.CatalogUserServiceDetail;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CatalogUserServiceDetailDTO {
    public Long id;
    public CatalogUserService idUserCatalogService;
    public String fileBase64;
    public CatalogUserServiceDetailDTO(CatalogUserServiceDetail catalogUserServiceDetail) {
        this.id = catalogUserServiceDetail.getId();
        this.idUserCatalogService = catalogUserServiceDetail.getCatalogUserService();
        this.fileBase64 = catalogUserServiceDetail.getFileBase64();
    }
}
