package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.CatalogTypeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatalogTypeServiceRepository extends JpaRepository<CatalogTypeService, Long> {
    @Query(value = "SELECT c FROM CatalogTypeService c WHERE c.isActive ORDER BY c.typeServiceNameEs")
    List<CatalogTypeService> findAllisActive();
}
