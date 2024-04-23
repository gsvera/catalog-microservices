package com.esthetic.catalogmicroservices.controller;

import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.service.CatalogStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/esthetic/catalog-status")
public class CatalogStatusController {

    @Autowired
    private CatalogStatusService catalogStatusService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getAllCatalogStatus() {
        ResponseDTO response = new ResponseDTO();
        try {
            response.items = catalogStatusService.getAllCatalogStatus();
        } catch(Exception ex) {
            response.error = true;
            // response.message = ex.getMessage();
        }
        return response;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getById(@PathVariable("id") Long id) {
        ResponseDTO response = new ResponseDTO();
        try{
            response.items = catalogStatusService.getById(id);
        } catch(Exception ex) {
            response.error = true;
            // response.message = ex.getMessage();
        }
        return response;
    }
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getByNameEs(@PathVariable("name") String statusNameEs) {
        ResponseDTO response = new ResponseDTO();
        try{
            response.items = catalogStatusService.getByName(statusNameEs);
        } catch(Exception ex) {
            // response.message = ex.getMessage();
            response.error = true;
        }
        return response;
    }
}
