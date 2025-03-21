package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "tbl_type_service_x_user")
@RequiredArgsConstructor
public class TypeServiceXUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_user")
    private String idUser;
    @Column(name = "id_type_service")
    private Long idTypeService;
    public TypeServiceXUser(String idUser, Long idTypeService) {
        this.idUser = idUser;
        this.idTypeService = idTypeService;
    }
}
