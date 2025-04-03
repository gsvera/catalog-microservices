package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_description_service")
@AllArgsConstructor
public class DescriptionService {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_user")
    private String idUser;
    @Column(name = "general_description")
    private String generalDescription;
    public DescriptionService(){} // Se requiere por el Jpa
    public DescriptionService(String idUser, String generalDescription) {
        this.idUser = idUser;
        this.generalDescription = generalDescription;
    }
}
