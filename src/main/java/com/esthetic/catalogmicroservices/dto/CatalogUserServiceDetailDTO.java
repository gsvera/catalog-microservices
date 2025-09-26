package com.esthetic.catalogmicroservices.dto;

import com.esthetic.catalogmicroservices.entity.CatalogUserService;
import com.esthetic.catalogmicroservices.entity.CatalogUserServiceDetail;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CatalogUserServiceDetailDTO {
    public Long id;
    public CatalogUserService idUserCatalogService;
    public String fileUrl;
    public String fileName;
    public CatalogUserServiceDetailDTO(CatalogUserServiceDetail catalogUserServiceDetail) {
        this.id = catalogUserServiceDetail.getId();
        this.idUserCatalogService = catalogUserServiceDetail.getCatalogUserService();
        this.fileUrl = catalogUserServiceDetail.getFileUrl();
        this.fileName = catalogUserServiceDetail.getFileName();
    }
}
