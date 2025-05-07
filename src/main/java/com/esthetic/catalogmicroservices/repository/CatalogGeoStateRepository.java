package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.CatalogGeoState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogGeoStateRepository extends JpaRepository<CatalogGeoState, Long> {
}
