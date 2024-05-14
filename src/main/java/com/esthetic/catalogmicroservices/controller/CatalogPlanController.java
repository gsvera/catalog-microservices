package com.esthetic.catalogmicroservices.controller;

import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.service.CatalogPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/esthetic/catalog-plan")
public class CatalogPlanController {
    @Autowired
    private CatalogPlanService catalogPlanService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getAllPlan(){
        ResponseDTO response = new ResponseDTO();
        try {
            response.items = catalogPlanService.getAllPlan();
        } catch(Exception ex) {
            response.error = true;
            System.out.println(ex.getMessage());
        }
        return response;
    }
}
