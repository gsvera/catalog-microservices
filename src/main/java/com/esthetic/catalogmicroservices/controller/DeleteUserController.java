package com.esthetic.catalogmicroservices.controller;

import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/esthetic/delete-user")
public class DeleteUserController {
    @Autowired
    private DeleteService deleteService;
    @DeleteMapping("/delete-catalog-account/{id-user}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO DeleteCatalogAccount(@PathVariable(name = "id-user") String idUser) {
        try{
            return deleteService._DeleteAllCatalogsByUser(idUser);
        }catch (Exception ex) {
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
}
