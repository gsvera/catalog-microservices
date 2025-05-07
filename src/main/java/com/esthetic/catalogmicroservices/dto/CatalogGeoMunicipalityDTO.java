package com.esthetic.catalogmicroservices.dto;

import com.esthetic.catalogmicroservices.entity.CatalogGeoMunicipality;

public class CatalogGeoMunicipalityDTO {
    public Long id;
    public Long stateId;
    public String municipalityName;
    public Double latitude;
    public Double longitude;
    public CatalogGeoMunicipalityDTO(){} // Constructor aux
    public CatalogGeoMunicipalityDTO(CatalogGeoMunicipality catalogGeoMunicipality) {
        this.id = catalogGeoMunicipality.getId();
        this.stateId = catalogGeoMunicipality.getStateId();
        this.municipalityName = catalogGeoMunicipality.getMunicipalityName();
        this.latitude = catalogGeoMunicipality.getLatitude();
        this.longitude = catalogGeoMunicipality.getLongitude();
    }
}
