package com.esthetic.catalogmicroservices.dto;

import com.esthetic.catalogmicroservices.entity.DescriptionService;

public class DescriptionServiceDTO {
    public Long id;
    public String idUser;
    public String generalDescription;
    public DescriptionServiceDTO(DescriptionService descriptionService){
        this.id = descriptionService.getId();
        this.idUser = descriptionService.getIdUser();
        this.generalDescription = descriptionService.getGeneralDescription();
    }
}
