package com.esthetic.catalogmicroservices.entity;

import com.esthetic.catalogmicroservices.dto.CatalogUserServiceDetailDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_user_catalog_service_detail")
@AllArgsConstructor
@NoArgsConstructor
public class CatalogUserServiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_user_catalog_service")
    private Long idUserCatalogService;
    @Column(name = "file_base_64")
    private String fileBase64;
    public CatalogUserServiceDetail(CatalogUserServiceDetailDTO catalogUserServiceDetailDTO) {
        this.idUserCatalogService = catalogUserServiceDetailDTO.idUserCatalogService;
        this.fileBase64 = catalogUserServiceDetailDTO.fileBase64;
    }
}
