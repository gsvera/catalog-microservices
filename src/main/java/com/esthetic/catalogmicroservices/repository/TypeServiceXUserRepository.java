package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.TypeServiceXUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeServiceXUserRepository extends JpaRepository<TypeServiceXUser, Long> {
    @Query(value = "SELECT * FROM tbl_type_service_x_user WHERE id_user = ?1", nativeQuery = true)
    List<TypeServiceXUser> findByIdUser(String idUser);
    @Query(value = "SELECT tsu.id, ct.id, ct.type_service_name_es FROM tbl_type_service_x_user AS tsu LEFT JOIN tbl_catalog_type_service AS ct ON tsu.id_type_service = ct.id WHERE tsu.id_user = ?1", nativeQuery = true)
    List<Object[]> findTypesByUser(String idUser);
}
