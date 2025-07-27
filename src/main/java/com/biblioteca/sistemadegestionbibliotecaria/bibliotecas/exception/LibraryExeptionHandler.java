package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.exception;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.out.LibraryErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LibraryExeptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public LibraryErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
                .toList().toString();
        return new LibraryErrorResponse(errors);
    }

    @ExceptionHandler(LibraryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public LibraryErrorResponse handleLibraryNotFoundException(LibraryNotFoundException ex) {
        return new LibraryErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(LibraryException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public LibraryErrorResponse handleLibraryException(LibraryException ex) {
        return new LibraryErrorResponse(ex.getMessage());
    }



}