package com.esthetic.catalogmicroservices.dto;

import com.esthetic.catalogmicroservices.entity.TypeServiceXUser;

public class TypeServiceXUserDTO {
    public Long id;
    public String idUser;
    public Long idTypeService;
    public String nameType; // Aux
    public TypeServiceXUserDTO(){};
    public TypeServiceXUserDTO(TypeServiceXUser typeServiceXUser) {
        this.id = typeServiceXUser.getId();
        this.idUser = typeServiceXUser.getIdUser();
        this.idTypeService = typeServiceXUser.getIdTypeService();
    }
}
