package com.esthetic.catalogmicroservices.controller;

import com.esthetic.catalogmicroservices.dto.CatalogUserServiceDTO;
import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.service.CatalogTypeServiceService;
import com.esthetic.catalogmicroservices.service.CatalogUserServiceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseDTO SaveTypeServiceByUser (@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody Map<String,Object> requestBody) {
        try{
            String idUser = (String) requestBody.get("idUser");
            String ids = (String) requestBody.get("idsType");
            List<Long> lisId = Arrays.stream(ids.split(",")).map(Long::valueOf).collect(Collectors.toList());
            return catalogTypeServiceService._SaveTypeServiceByUser(token, idUser, lisId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
    @PostMapping("/save-catalog-user-service")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO SaveCatalogUserService(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestParam(name = "files") List<MultipartFile> files, @RequestParam String catalogUserServiceDTOJson) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            CatalogUserServiceDTO catalogUserServiceDTO = mapper.readValue(catalogUserServiceDTOJson, CatalogUserServiceDTO.class);

            return catalogUserServiceService._SaveCatalogService(token, catalogUserServiceDTO, files);
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
    @PutMapping("/update-catalog-user-service")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO UpdateCatalogUserService(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestParam(name = "files", required = false) List<MultipartFile> files, @RequestParam String catalogUserServiceDTOJson) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            CatalogUserServiceDTO catalogUserServiceDTO = mapper.readValue(catalogUserServiceDTOJson, CatalogUserServiceDTO.class);
            return catalogUserServiceService._UpdateCatalogUserService(token, catalogUserServiceDTO, files);
        } catch (Exception ex) {
            System.out.println(ex);
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
    @GetMapping("/service-get-by-user/{id-user}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO GetCatalogServiceByUser(@PathVariable("id-user") String idUser) {
        try{
            return catalogUserServiceService._GetByUser(idUser);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
    @GetMapping("/get-catalog-service-by-id/{id-catalog}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO GetCatalogServiceById(@PathVariable("id-catalog") Long idCatalog) {
        try{
            return catalogUserServiceService._GetCatalogServiceById(idCatalog);
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
    @DeleteMapping("/delete-catalog-service-by-id/{id-catalog}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO DeleteCatalogServiceById(@PathVariable("id-catalog") Long idCatalog) {
        try{
            return  catalogUserServiceService._DeleteCatalogServiceById(idCatalog);
        } catch (Exception ex) {
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo más tarde").build();
        }
    }
}
