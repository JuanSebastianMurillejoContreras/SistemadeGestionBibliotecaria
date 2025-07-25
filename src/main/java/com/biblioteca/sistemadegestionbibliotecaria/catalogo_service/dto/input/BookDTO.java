package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.dto.input.LibraryDTO;

public record BookDTO(
        String title,
        String isbn,
        AuthorDTO author,
        LibraryDTO library
) {}
