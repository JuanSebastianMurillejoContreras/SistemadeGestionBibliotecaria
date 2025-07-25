package com.biblioteca.sistemadegestionbibliotecaria.author.dto.input;

import jakarta.validation.constraints.NotBlank;

public record AuthorCreateDTO(
        @NotBlank(message = "El título no puede estar vacío")
        String name
) {
}
