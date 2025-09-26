package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.CatalogUserServiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CatalogUserServiceDetailRepository extends JpaRepository<CatalogUserServiceDetail, Long> {
    @Query(value = "SELECT id, id_user_catalog_service, file_url, file_name FROM tbl_user_catalog_service_detail WHERE id_user_catalog_service = ?1", nativeQuery = true)
    List<CatalogUserServiceDetail> findByIdUserCatalogService(Long id);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tbl_user_catalog_service_detail WHERE id_user_catalog_service = ?1", nativeQuery = true)
    int deleteDetailByUserCatalogService(Long id);
}
