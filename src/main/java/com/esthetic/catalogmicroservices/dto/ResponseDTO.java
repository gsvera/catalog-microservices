package com.esthetic.catalogmicroservices.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    public boolean error;
    public Object items;
    public String message;

    public ResponseDTO(Object obj) {
        this.items = obj;
    }
}
