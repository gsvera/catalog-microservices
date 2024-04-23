package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.CatalogTypeService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogTypeServiceRepository extends JpaRepository<CatalogTypeService, Long> {
}
