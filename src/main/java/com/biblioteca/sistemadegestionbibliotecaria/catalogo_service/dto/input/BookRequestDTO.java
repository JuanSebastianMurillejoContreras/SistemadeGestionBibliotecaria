package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input;

public record BookRequestDTO(
        String title,
        String isbn,
        Long authorId,
        Long libraryId
) {}
