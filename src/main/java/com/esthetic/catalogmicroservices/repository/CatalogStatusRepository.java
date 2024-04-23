package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.CatalogStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogStatusRepository extends JpaRepository <CatalogStatus, Long>{
    
    CatalogStatus findByStatusNameEs(String statusNameEs);
}
