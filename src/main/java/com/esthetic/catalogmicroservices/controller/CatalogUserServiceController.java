package com.esthetic.catalogmicroservices.controller;

import com.esthetic.catalogmicroservices.dto.CatalogUserServiceDTO;
import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.entity.CatalogUserService;
import com.esthetic.catalogmicroservices.service.CatalogTypeServiceService;
import com.esthetic.catalogmicroservices.service.CatalogUserServiceService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/esthetic/auth/catalog-type-user-service")
public class CatalogUserServiceController {
    @Autowired
    private CatalogUserServiceService catalogUserServiceService;
    @Autowired
    private CatalogTypeServiceService catalogTypeServiceService;
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO SaveCatalogUserService(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody CatalogUserServiceDTO catalogUserServiceDTO) {
        try{
            return catalogUserServiceService.SaveCatalogUserService(token, catalogUserServiceDTO);
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
    @GetMapping("/service-get-by-user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO GetCatalogServiceByUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        ResponseDTO response = new ResponseDTO();
        try{
            response.items = catalogUserServiceService.GetByUser(token);
        } catch(Exception ex) {
            response.error = true;
            response.message = "Ocurrio un error intentelo mas tarde";
            System.out.println(ex.getMessage());
        }
        return response;
    }
    @GetMapping("/get-type-service-by-user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO GetTypeServiceByUser(@RequestParam(name = "id-user") String idUser) {
        try{
            return catalogTypeServiceService._GetTypeServiceByUser(idUser);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
    @PostMapping("/save-type-service-by-user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO SaveTypeServiceByUser (@RequestBody Map<String,Object> requestBody) {
        try{
            String idUser = (String) requestBody.get("idUser");
            String ids = (String) requestBody.get("idsType");
            List<Long> lisId = Arrays.stream(ids.split(",")).map(Long::valueOf).collect(Collectors.toList());
            return catalogTypeServiceService._SaveTypeServiceByUser(idUser, lisId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
}
