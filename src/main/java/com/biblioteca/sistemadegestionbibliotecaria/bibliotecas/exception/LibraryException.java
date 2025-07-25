package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.exception;


import lombok.Getter;

@Getter
public class LibraryException extends RuntimeException  {

    private String code;

    public LibraryException(String code, String message) {
        super(message);
        this.code = code;
    }
}