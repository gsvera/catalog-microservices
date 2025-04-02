package com.esthetic.catalogmicroservices.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class EnvConfig {
    @Value("${env.max_file_upload}")
    private int maxFileUpload;
}
