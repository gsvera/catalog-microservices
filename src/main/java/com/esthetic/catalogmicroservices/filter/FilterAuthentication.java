package com.esthetic.catalogmicroservices.filter;

import com.esthetic.catalogmicroservices.dto.ResponseDTO;
import com.google.gson.Gson;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FilterAuthentication extends OncePerRequestFilter {

    private static final List<String> EXCLUDED_PATH = Arrays.asList("/api/esthetic/catalog-plan", "/api/esthetic/catalog-lada-phone");
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(isExcludedPath(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        final String token = getTokenFromRequest(request);

        if(token == null) {
            filterChain.doFilter(request, response);
            return ;
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        headers.set("Authorization", "Bearer " + token);
        String apiUrl = "http://localhost:8002/api/esthetic/auth-user/get-data-user";

        ResponseEntity<String> responseApi = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        if(responseApi.getStatusCode().is2xxSuccessful()) {
            Gson objGson = new Gson();
            ResponseDTO responseDTO = objGson.fromJson(responseApi.getBody(), ResponseDTO.class);
            if(responseDTO.error != true) {
                filterChain.doFilter(request, response);
            }
        } else {
            return;
        }

    }
    private boolean isExcludedPath(HttpServletRequest request) {
        String requestPath = request.getRequestURI();
        return EXCLUDED_PATH.stream().anyMatch(requestPath::startsWith);
    }
    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")){
            return authHeader.substring(7);
        }
        return null;
    }
}
