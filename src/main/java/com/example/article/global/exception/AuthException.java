package com.example.article.global.exception;

import org.springframework.http.HttpStatus;

public class AuthException extends BusinessException {
    public AuthException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
