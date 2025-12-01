package com.example.article.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException{

    private final HttpStatus status;
    private String message;

    public BusinessException(HttpStatus status, final String message) {
        this.status = status;
        this.message = message;
    }

}
