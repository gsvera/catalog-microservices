package com.esthetic.catalogmicroservices.cron;

import com.esthetic.catalogmicroservices.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MunicipalityTask {
    @Autowired
    private CatalogService catalogService;
    //@Transactional
    //@Scheduled(fixedDelay = 2000)
    //public void ExecuteUpdate() {
     //   try{
       //     catalogService._UpdateMunicipality();
        //} catch (Exception ex) {
          //  System.out.println(ex.getMessage());
        //}
    //}
}
