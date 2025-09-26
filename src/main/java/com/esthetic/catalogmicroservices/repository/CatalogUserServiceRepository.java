package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.CatalogUserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatalogUserServiceRepository extends JpaRepository<CatalogUserService, Long> {
    @Query(value = "SELECT DISTINCT ON (ucs.id) ucs.id, ucs.name_service, ucs.min_price, ucs.max_price, ucsd.id, ucsd.file_url, COUNT(ucsd.id) OVER (PARTITION BY ucs.id) AS total_element \n" +
            "FROM tbl_user_catalog_service AS ucs LEFT JOIN tbl_user_catalog_service_detail AS ucsd ON ucs.id = ucsd.id_user_catalog_service \n" +
            "WHERE ucs.id_user = ?1", nativeQuery = true)
    List<Object[]>  findAllByIdUser(String idUser);
    @Query(value = "SELECT c FROM CatalogUserService c LEFT JOIN FETCH c.detail WHERE c.id = ?1")
    CatalogUserService findCatalogByIdWithDetail(Long id);
    List<CatalogUserService> findByIdUser(String id);
}
