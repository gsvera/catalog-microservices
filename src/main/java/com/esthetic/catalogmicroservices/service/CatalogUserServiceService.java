package com.esthetic.catalogmicroservices.service;

import com.esthetic.catalogmicroservices.dto.CatalogUserServiceDTO;
import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.entity.CatalogUserService;
import com.esthetic.catalogmicroservices.entity.User;
import com.esthetic.catalogmicroservices.repository.CatalogUserServiceRepository;
import com.esthetic.catalogmicroservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogUserServiceService {
    private final CatalogUserServiceRepository catalogUserServiceRepository;
    private final UserRepository userRepository;

    public ResponseDTO SaveCatalogUserService(String token, CatalogUserServiceDTO catalogUserServiceDTO) {
        ResponseDTO response = new ResponseDTO();
        Optional<User> user = userRepository.findByToken(token.substring(7));

        CatalogUserService getCatalogUserService = catalogUserServiceRepository.findByidUserAndIdService(user.get().getId(), catalogUserServiceDTO.getIdService());

        if(getCatalogUserService == null) {
            CatalogUserService newCatalogUserService = new CatalogUserService(
                    0,
                    user.get().getId(),
                    catalogUserServiceDTO.getIdService(),
                    catalogUserServiceDTO.getMinPrice(),
                    catalogUserServiceDTO.getMaxPrice()
            );
            catalogUserServiceRepository.save(newCatalogUserService);
            response.error = false;
            return response;
        } else{
            response.items = getCatalogUserService;
            response.error = true;
            return response;
        }
    }
    public List<CatalogUserServiceDTO> GetByUser(String token) {
        List<CatalogUserService> list = (List<CatalogUserService>) catalogUserServiceRepository.findAllByIdUser(token.substring(7));
        return list.stream().map(item -> new CatalogUserServiceDTO(item)).collect(Collectors.toList());
    }
}
