package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.exception;


import lombok.Getter;

@Getter
public class AuthorException extends RuntimeException  {

    private String code;

    public AuthorException(String code, String message) {
        super(message);
        this.code = code;
    }
}