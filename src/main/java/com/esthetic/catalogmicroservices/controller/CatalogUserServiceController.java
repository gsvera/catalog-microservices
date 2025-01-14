package com.esthetic.catalogmicroservices.controller;

import com.esthetic.catalogmicroservices.dto.CatalogUserServiceDTO;
import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.entity.CatalogUserService;
import com.esthetic.catalogmicroservices.service.CatalogUserServiceService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/esthetic/auth/catalog-type-user-service")
public class CatalogUserServiceController {
    @Autowired
    private CatalogUserServiceService catalogUserServiceService;
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO SaveCatalogUserService(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody CatalogUserServiceDTO catalogUserServiceDTO) {
        ResponseDTO response = new ResponseDTO();
        try{
            response = catalogUserServiceService.SaveCatalogUserService(token, catalogUserServiceDTO);
        }catch (Exception ex) {
            response.error = true;
            System.out.println(ex.getMessage());
        }
        return response;
    }
    @GetMapping("/service-get-by-user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO GetCatalogServiceByUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        ResponseDTO response = new ResponseDTO();
        try{
            response.items = catalogUserServiceService.GetByUser(token);
        } catch(Exception ex) {
            response.error = true;
            System.out.println(ex.getMessage());
        }
        return response;
    }
}
