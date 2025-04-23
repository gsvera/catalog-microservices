package com.esthetic.catalogmicroservices.controller;

import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.service.CatalogTypeServiceService;
import com.esthetic.catalogmicroservices.service.CatalogUserServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/esthetic/catalog-type-service")
public class CatalogTypeServiceController {
    @Autowired
    private CatalogTypeServiceService catalogTypeServiceService;
    @Autowired
    private CatalogUserServiceService catalogUserServiceService;
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
    @GetMapping("/get-types-by-user/{id-user}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getTypesByUser(@PathVariable(name = "id-user") String idUser) {
        try{
            return catalogTypeServiceService._GetTypesNamesByUser(idUser);
        } catch (Exception ex) {
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
    @GetMapping("/get-services-by-user/{id-user}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO GetServicesByUser(@PathVariable(name = "id-user")String idUser) {
        try{
            return catalogUserServiceService._GetByUser(idUser);
        } catch (Exception ex) {
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
    @GetMapping("/get-detail-service-by-id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO GetDetailServiceById(@RequestParam(name = "id-project")Long idProject) {
        try{
            return catalogUserServiceService._GetDetailCatalogServiceById(idProject);
        } catch (Exception ex) {
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
}
