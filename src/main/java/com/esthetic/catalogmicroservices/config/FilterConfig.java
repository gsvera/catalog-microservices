package com.esthetic.catalogmicroservices.config;

import com.esthetic.catalogmicroservices.filter.FilterAuthentication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<FilterAuthentication> filterAuthenticationUser() {
        FilterRegistrationBean<FilterAuthentication> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new FilterAuthentication());
        registrationBean.addUrlPatterns("/api/esthetic/catalog-user-service/*");

        return registrationBean;
    }
}
