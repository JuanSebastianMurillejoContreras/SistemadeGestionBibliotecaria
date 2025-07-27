package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.exception;

import lombok.Getter;

@Getter
public class LibraryException extends RuntimeException  {

    public LibraryException(String message) {
        super(message);
    }
}