package com.esthetic.catalogmicroservices.config;

import com.esthetic.catalogmicroservices.filter.FilterAuthentication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<FilterAuthentication> filterAuthenticationUser(FilterAuthentication filterAuthentication) {
        FilterRegistrationBean<FilterAuthentication> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(filterAuthentication);

        return registrationBean;
    }
}
