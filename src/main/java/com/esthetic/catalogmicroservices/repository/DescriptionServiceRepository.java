package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.DescriptionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface DescriptionServiceRepository extends JpaRepository<DescriptionService, Long> {
    Optional<DescriptionService> findByIdUser(String idUser);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tbl_description_service WHERE id_user = ?1", nativeQuery = true)
    int deleteByUserId(String id);
}
