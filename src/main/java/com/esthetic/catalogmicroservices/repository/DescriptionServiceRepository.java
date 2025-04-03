package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.DescriptionService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DescriptionServiceRepository extends JpaRepository<DescriptionService, Long> {
    Optional<DescriptionService> findByIdUser(String idUser);
}
