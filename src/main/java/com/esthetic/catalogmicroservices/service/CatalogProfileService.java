package com.esthetic.catalogmicroservices.service;

import com.esthetic.catalogmicroservices.dto.CatalogProfileDTO;
import com.esthetic.catalogmicroservices.entity.CatalogProfile;
import com.esthetic.catalogmicroservices.repository.CatalogProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatalogProfileService {
    private final CatalogProfileRepository catalogProfileRepository;

    public CatalogProfileService(CatalogProfileRepository catalogProfileRepository) {
        this.catalogProfileRepository =  catalogProfileRepository;
    }

    public List<CatalogProfileDTO> getAllCatalogProfile() {
        List<CatalogProfile> catalogProfiles = catalogProfileRepository.findAll();
        return catalogProfiles.stream().map(item -> new CatalogProfileDTO(
                item.getId(),
                item.getProfileNameEs(),
                item.getProfileNameEn(),
                item.getDescriptionEs(),
                item.getDescriptionEn()
        )).collect(Collectors.toList());
    }

    public CatalogProfileDTO getById(Long id) {
        Optional<CatalogProfile> catalogProfile = catalogProfileRepository.findById(id);

        return new CatalogProfileDTO(
                catalogProfile.get().getId(),
                catalogProfile.get().getProfileNameEs(),
                catalogProfile.get().getProfileNameEn(),
                catalogProfile.get().getDescriptionEs(),
                catalogProfile.get().getDescriptionEn()
        );
    }
}
