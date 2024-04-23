package com.esthetic.catalogmicroservices.controller;

import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.service.CatalogLadaPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/esthetic/catalog-lada-phone")
public class CatalogLadaPhoneController {
    @Autowired
    private CatalogLadaPhoneService catalogLadaPhoneService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getAllCatalogLadaPhone() {
        ResponseDTO response = new ResponseDTO();
        try {
            response.items = catalogLadaPhoneService.getAllCatalogLadaPhone();
        } catch(Exception ex) {
            response.error = true;
            // response.message = ex.getMessage();
        }
        return response;
    }
}
