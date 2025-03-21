package com.esthetic.catalogmicroservices.controller;

import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.service.CatalogTypeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/esthetic/catalog-type-service")
public class CatalogTypeServiceController {
    @Autowired
    private CatalogTypeServiceService catalogTypeServiceService;
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getAllCatalogTypeService() {
        ResponseDTO response = new ResponseDTO();
        try{
            response.items = catalogTypeServiceService.getAllCatalogTypeService();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            response.error = true;
            response.message = "Ocurrio un error intentelo mas tarde";
        }
        return response;
    }

    @GetMapping("/get-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getById(@PathVariable("id") Long id) {
        ResponseDTO response = new ResponseDTO();
        try {
            response.items = catalogTypeServiceService.getById(id);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            response.error = true;
            response.message = "Ocurrio un error intentelo mas tarde";
        }
        return response;
    }
}
