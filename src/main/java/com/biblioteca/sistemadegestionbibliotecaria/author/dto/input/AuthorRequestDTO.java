package com.biblioteca.sistemadegestionbibliotecaria.author.dto.input;

import jakarta.validation.constraints.NotBlank;

public record AuthorRequestDTO(
        @NotBlank(message = "El nombre no puede estar vacío")
        String name
) {}
