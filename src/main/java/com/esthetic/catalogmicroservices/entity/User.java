package com.esthetic.catalogmicroservices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "tbl_user")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    private String id;
    private String token;
}
