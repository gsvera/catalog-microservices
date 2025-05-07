package com.esthetic.catalogmicroservices.repository;

import com.esthetic.catalogmicroservices.entity.CatalogGeoMunicipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatalogGeoMunicipalityRepository extends JpaRepository<CatalogGeoMunicipality, Long> {
    @Query(value = "select \n" +
            "m.id, s.state_name, m.municipality_name \n" +
            "from esthetic_base.tbl_catalog_geo_municipality AS m \n" +
            "left join esthetic_base.tbl_catalog_geo_state AS s ON s.id =m.state_id\n" +
            "WHERE m.latitude IS NULL LIMIT 1", nativeQuery = true)
    List<Object[]> findEmpty();
    @Query(value = "SELECT * FROM tbl_catalog_geo_municipality WHERE state_id = ?1 ORDER BY municipality_name", nativeQuery = true)
    List<CatalogGeoMunicipality> findByStateId(Long id);
}
