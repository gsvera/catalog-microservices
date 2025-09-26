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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogUserServiceService {
    private final EnvConfig envConfig;
    private final CatalogUserServiceRepository catalogUserServiceRepository;
    private final CatalogUserServiceDetailRepository catalogUserServiceDetailRepository;
    private final SpaceService spaceService;

    public ResponseDTO _SaveCatalogService(CatalogUserServiceDTO catalogUserServiceDTO, List<MultipartFile> files) throws IOException{
        List<CatalogUserService> list = catalogUserServiceRepository.findByIdUser(catalogUserServiceDTO.idUser);
        if(list.size() >= envConfig.getMaxFileUpload()) {
            return ResponseDTO.builder().error(true).message("Ha alcanzado el maximo de registros para guardar").build();
        }
        CatalogUserService newCatalogUserService = new CatalogUserService(catalogUserServiceDTO);
        catalogUserServiceRepository.save(newCatalogUserService);
        this._SaveDetailCatalogUserService(newCatalogUserService, files);
        return ResponseDTO.builder().message("Registro guardado con éxito").build();
    }
    public ResponseDTO _UpdateCatalogUserService(CatalogUserServiceDTO catalogUserServiceDTO, List<MultipartFile> files) throws IOException{
        try{
            CatalogUserService catalogUserService = new CatalogUserService(catalogUserServiceDTO);
            catalogUserService.setId(catalogUserServiceDTO.id);
            catalogUserServiceRepository.save(catalogUserService);

            List<CatalogUserServiceDetail> listDetail = catalogUserServiceDetailRepository.findByIdUserCatalogService(catalogUserServiceDTO.id);

            List<CatalogUserServiceDetail> missing = listDetail.stream().filter(item -> !catalogUserServiceDTO.existingFiles.contains(item.getId())).collect(Collectors.toList());

            for(CatalogUserServiceDetail item : missing) {
                spaceService.deleteFile(item.getFileUrl());
                catalogUserServiceDetailRepository.deleteById(item.getId());
            }

            if(files != null) {
                this._SaveDetailCatalogUserService(catalogUserService, files);
            }

            return ResponseDTO.builder().message("Registro guardado con éxito").build();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
    public void _SaveDetailCatalogUserService(CatalogUserService catalogUserService, List<MultipartFile> files) throws IOException {
        try{
            for(MultipartFile file : files) {
                String fileName = envConfig.getDirCatalog() +"/"+ catalogUserService.getIdUser() + "/" + file.getOriginalFilename();
                String urlProfile = spaceService.uploadFile(fileName, file.getContentType(), file.getInputStream(), file.getSize());

                CatalogUserServiceDetailDTO catalogUserServiceDetailDTO = new CatalogUserServiceDetailDTO();
                catalogUserServiceDetailDTO.idUserCatalogService = catalogUserService;
                catalogUserServiceDetailDTO.fileUrl = urlProfile;
                catalogUserServiceDetailDTO.fileName = file.getOriginalFilename();

                catalogUserServiceDetailRepository.save(new CatalogUserServiceDetail(catalogUserServiceDetailDTO));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
            catalogUserServiceDetailDTO.fileUrl = (String)row[5];
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
    public ResponseDTO _GetDetailCatalogServiceById(Long idProject) {
        List<CatalogUserServiceDetail> catalogUserServiceDetailList = catalogUserServiceDetailRepository.findByIdUserCatalogService(idProject);
        return ResponseDTO.builder().items(catalogUserServiceDetailList.stream().map(item -> new CatalogUserServiceDetailDTO(item))).build();
    }
    public ResponseDTO _DeleteCatalogServiceById(Long idCatalog) throws IOException {
        try{
            if(!catalogUserServiceRepository.existsById(idCatalog)) {
                return ResponseDTO.builder().error(true).message("El registro no existe").build();
            }
            List<CatalogUserServiceDetail> list = catalogUserServiceDetailRepository.findByIdUserCatalogService(idCatalog);


            for (CatalogUserServiceDetail item : list) {
                spaceService.deleteFile(item.getFileUrl());
            }

            catalogUserServiceDetailRepository.deleteDetailByUserCatalogService(idCatalog);

            catalogUserServiceRepository.deleteById(idCatalog);
            return ResponseDTO.builder().message("Registro eliminado con éxito").build();
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return ResponseDTO.builder().error(true).message("Ocurrio un error intentelo mas tarde").build();
        }
    }
}
