package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.exception;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.out.ErrorResponse;
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
    public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
                .toList().toString();
        return new ErrorResponse(errors);
    }

    @ExceptionHandler(LibraryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoNotificationsFoundException(LibraryNotFoundException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(LibraryException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleLibroException(LibraryException ex) {
        return new ErrorResponse(ex.getMessage());
    }



}