package com.esthetic.catalogmicroservices.controller;

import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/esthetic/catalog/")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;
    @GetMapping("/catalog-geo-state/get-all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO CatalogGeoSateGetAll() {
        try{
            return catalogService._GetCatalogGeoState();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
    @GetMapping("/catalog-geo-municipality-by-state")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO CatalogGeoMunicipalityByState(@RequestParam(name = "id-state")Long idState) {
        try{
            return catalogService._GetMunicipalityByState(idState);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
}
