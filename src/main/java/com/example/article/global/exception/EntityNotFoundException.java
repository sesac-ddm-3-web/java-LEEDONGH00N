package com.example.article.global.exception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends BusinessException {
    public EntityNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
