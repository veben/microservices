package com.veben.microservices.developer.ext.exception.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorDto {
    private int status;
    private String message;

    public ErrorDto(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
