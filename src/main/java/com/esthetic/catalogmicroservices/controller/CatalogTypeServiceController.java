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
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getAllCatalogTypeService() {
        ResponseDTO response = new ResponseDTO();
        try{
            response.items = catalogTypeServiceService.getAllCatalogTypeService();
        } catch(Exception ex) {
            response.error = true;
            System.out.println(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getById(@PathVariable("id") Long id) {
        ResponseDTO response = new ResponseDTO();
        try {
            response.items = catalogTypeServiceService.getById(id);
        } catch(Exception ex) {
            response.error = true;
            // response.message = ex.getMessage();
        }
        return response;
    }
}
