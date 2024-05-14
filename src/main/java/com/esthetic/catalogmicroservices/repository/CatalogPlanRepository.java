package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.CatalogPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogPlanRepository extends JpaRepository<CatalogPlan, Long> {

}
