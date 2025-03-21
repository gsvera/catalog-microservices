package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.TypeServiceXUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeServiceXUserRepository extends JpaRepository<TypeServiceXUser, Long> {
    @Query(value = "SELECT * FROM tbl_type_service_x_user WHERE id_user = ?1", nativeQuery = true)
    List<TypeServiceXUser> findByIdUser(String idUser);
}
