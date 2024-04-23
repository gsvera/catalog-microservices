package com.esthetic.catalogmicroservices.controller;

import com.esthetic.catalogmicroservices.dto.CatalogProfileDTO;
import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.service.CatalogProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/esthetic/catalog-profile")
public class CatalogProfileController {
    @Autowired
    private CatalogProfileService catalogProfileService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getAllCatalogProfile() {
        ResponseDTO response = new ResponseDTO();
        try{
            response.items = catalogProfileService.getAllCatalogProfile();
        } catch(Exception ex) {
            response.error = true;
            // response.message = ex.getMessage();
        }
        return response;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getCatalogProfileById(@PathVariable("id") Long id) {
        ResponseDTO response = new ResponseDTO();
        try{
            response.items = catalogProfileService.getById(id);
        } catch(Exception ex) {
            response.error = true;
            // response.message = ex.getMessage();
        }
        return response;
    }
}
