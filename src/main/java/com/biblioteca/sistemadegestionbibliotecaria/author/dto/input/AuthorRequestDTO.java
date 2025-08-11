package com.biblioteca.sistemadegestionbibliotecaria.author.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AuthorRequestDTO(
        @NotBlank(message = "El nombre del autor no puede estar vacío")
        String name
) {}
