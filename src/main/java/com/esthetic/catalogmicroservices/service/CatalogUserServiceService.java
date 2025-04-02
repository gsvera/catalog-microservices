package com.esthetic.catalogmicroservices.service;

import com.esthetic.catalogmicroservices.config.EnvConfig;
import com.esthetic.catalogmicroservices.dto.CatalogUserServiceDTO;
import com.esthetic.catalogmicroservices.dto.CatalogUserServiceDetailDTO;
import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.esthetic.catalogmicroservices.entity.CatalogUserService;
import com.esthetic.catalogmicroservices.entity.CatalogUserServiceDetail;
import com.esthetic.catalogmicroservices.repository.CatalogUserServiceDetailRepository;
import com.esthetic.catalogmicroservices.repository.CatalogUserServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogUserServiceService {
    private final EnvConfig envConfig;
    private final CatalogUserServiceRepository catalogUserServiceRepository;
    private final CatalogUserServiceDetailRepository catalogUserServiceDetailRepository;

    public ResponseDTO _SaveCatalogService(CatalogUserServiceDTO catalogUserServiceDTO ){
        List<CatalogUserService> list = catalogUserServiceRepository.findByIdUser(catalogUserServiceDTO.idUser);
        if(list.size() >= envConfig.getMaxFileUpload()) {
            return ResponseDTO.builder().error(true).message("Ha alcanzado el maximo de registros para guardar").build();
        }
        CatalogUserService newCatalogUserService = new CatalogUserService(catalogUserServiceDTO);
        catalogUserServiceRepository.save(newCatalogUserService);
        this._SaveDetailCatalogUserService(newCatalogUserService, catalogUserServiceDTO);
        return ResponseDTO.builder().message("Registro guardado con éxito").build();
    }
    public ResponseDTO _UpdateCatalogUserService(CatalogUserServiceDTO catalogUserServiceDTO) {
        CatalogUserService catalogUserService = new CatalogUserService(catalogUserServiceDTO);
        catalogUserService.setId(catalogUserServiceDTO.id);
        catalogUserServiceRepository.save(catalogUserService);
        catalogUserServiceDetailRepository.deleteDetailByUserCatalogService(catalogUserService.getId());
        this._SaveDetailCatalogUserService(catalogUserService, catalogUserServiceDTO);
        return ResponseDTO.builder().message("Registro guardado con éxito").build();
    }
    void _SaveDetailCatalogUserService(CatalogUserService catalogUserService, CatalogUserServiceDTO catalogUserServiceDTO) {
        for(CatalogUserServiceDetailDTO items : catalogUserServiceDTO.items) {
            items.idUserCatalogService = catalogUserService;
            catalogUserServiceDetailRepository.save(new CatalogUserServiceDetail(items));
        }
    }
    public ResponseDTO _GetByUser(String idUser) {
        List<Object[]> list = catalogUserServiceRepository.findAllByIdUser(idUser);
        List<CatalogUserServiceDTO> listCatalog = new ArrayList<>();
        for(Object[] row : list) {
            CatalogUserServiceDTO catalogUserServiceDTO = new CatalogUserServiceDTO();
            CatalogUserServiceDetailDTO catalogUserServiceDetailDTO = new CatalogUserServiceDetailDTO();
            catalogUserServiceDTO.id = (Long)row[0];
            catalogUserServiceDTO.nameService = (String)row[1];
            catalogUserServiceDTO.minPrice = (double) row[2];
            catalogUserServiceDTO.maxPrice = (double) row[3];
            catalogUserServiceDetailDTO.id = (Long) row[4];
            catalogUserServiceDetailDTO.fileBase64 = (String)row[5];
            catalogUserServiceDTO.totalElement = row[6] != null ? ((Number) row[6]).intValue() : 0;
            catalogUserServiceDTO.catalogUserServiceDetailDTO = catalogUserServiceDetailDTO;
            listCatalog.add(catalogUserServiceDTO);
        }
        return ResponseDTO.builder().items(listCatalog).build();
    }
    public ResponseDTO _GetCatalogServiceById(Long idCatalog) {
        return ResponseDTO.builder().items(
                catalogUserServiceRepository.findCatalogByIdWithDetail(idCatalog)
        ).build();
    }
    public ResponseDTO _DeleteCatalogServiceById(Long idCatalog) {
        if(!catalogUserServiceRepository.existsById(idCatalog)) {
            return ResponseDTO.builder().error(true).message("El registro no existe").build();
        }
        catalogUserServiceDetailRepository.deleteDetailByUserCatalogService(idCatalog);
        catalogUserServiceRepository.deleteById(idCatalog);

        return ResponseDTO.builder().message("Registro eliminado con éxito").build();
    }
}
