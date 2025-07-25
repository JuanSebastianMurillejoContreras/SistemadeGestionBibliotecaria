package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.exception;

import lombok.Getter;

@Getter
public class AuthorNotFoundException extends AuthorException {
    public AuthorNotFoundException(String code, String message) {
        super(code, message);
    }
}