package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.CatalogUserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface CatalogUserServiceRepository extends JpaRepository<CatalogUserService, Long> {
    @Query(value = "SELECT * FROM tbl_user_catalog_service cus WHERE cus.id_user = ?1 AND cus.id_service = ?2", nativeQuery = true)
    CatalogUserService findByidUserAndIdService(String idUser, int idService);
    @Query(value = "SELECT * FROM tbl_user_catalog_service cus WHERE cus.id_user = ?1", nativeQuery = true)
    CatalogUserService findAllByIdUser(String idUser);
}
