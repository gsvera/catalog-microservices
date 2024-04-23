package com.esthetic.catalogmicroservices.service;

import com.esthetic.catalogmicroservices.dto.CatalogLadaPhoneDTO;
import com.esthetic.catalogmicroservices.entity.CatalogLadaPhone;
import com.esthetic.catalogmicroservices.repository.CatalogLadaPhoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogLadaPhoneService {
    private final CatalogLadaPhoneRepository catalogLadaPhoneRepository;
    public CatalogLadaPhoneService (CatalogLadaPhoneRepository catalogLadaPhoneService) {
        this.catalogLadaPhoneRepository = catalogLadaPhoneService;
    }

    public List<CatalogLadaPhoneDTO> getAllCatalogLadaPhone() {
        List<CatalogLadaPhone> list = catalogLadaPhoneRepository.findAll();
        return list.stream().map(item -> new CatalogLadaPhoneDTO(
                item.getId(),
                item.getCode(),
                item.getLada(),
                item.getLang(),
                item.getCountryEs(),
                item.getCountryEn()
                )).collect(Collectors.toList());
    }
}
