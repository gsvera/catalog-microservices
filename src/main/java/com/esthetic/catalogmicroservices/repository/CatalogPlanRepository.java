package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.CatalogPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatalogPlanRepository extends JpaRepository<CatalogPlan, Long> {
    @Query(value = "SELECT * FROM tbl_catalog_plan WHERE active = ?1", nativeQuery = true)
    List<CatalogPlan> finByActive(@Param("active") int active);
}
