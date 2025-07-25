package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.exception;


import lombok.Getter;

@Getter
public class BookException extends RuntimeException  {

    private String code;

    public BookException(String code, String message) {
        super(message);
        this.code = code;
    }
}