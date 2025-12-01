package com.example.article.global.exception;

import org.springframework.http.HttpStatus;

public class AccessDeniedException extends BusinessException {
    public AccessDeniedException(String message) {
        super(HttpStatus.FORBIDDEN, message); // 403
    }
}