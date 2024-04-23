package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.CatalogProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogProfileRepository extends JpaRepository<CatalogProfile, Long> {
}
