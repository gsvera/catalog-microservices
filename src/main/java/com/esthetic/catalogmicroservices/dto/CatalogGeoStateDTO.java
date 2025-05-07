package com.esthetic.catalogmicroservices.dto;

import com.esthetic.catalogmicroservices.entity.CatalogGeoState;

public class CatalogGeoStateDTO {
    public Long id;
    public String stateName;
    public CatalogGeoStateDTO(CatalogGeoState catalogGeoState) {
        this.id = catalogGeoState.getId();
        this.stateName = catalogGeoState.getStateName();
    }
}
