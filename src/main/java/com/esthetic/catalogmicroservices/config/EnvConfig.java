package com.esthetic.catalogmicroservices.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class EnvConfig {
    @Value("${env.max_file_upload}")
    private int maxFileUpload;
    @Value("${my.property.api.gateway}")
    private String apiGateway;
    @Value("${cloud.aws.se.bucket}")
    private String s3Bucket;
    @Value("${cloud.aws.s3.accesskey}")
    private String s3AccessKey;
    @Value("${cloud.aws.s3.secretkey}")
    private String s3SecretKey;
    @Value("${cloud.aws.s3.region}")
    private String s3Region;
    @Value("${cloud.aws.s3.dirprofile}")
    private String dirProfile;
    @Value("${cloud.aws.s3.dircatalog}")
    private String dirCatalog;
}
