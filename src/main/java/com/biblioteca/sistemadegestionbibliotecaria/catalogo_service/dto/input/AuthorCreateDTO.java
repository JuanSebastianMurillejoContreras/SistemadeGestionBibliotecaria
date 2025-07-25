package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input;

import jakarta.validation.constraints.NotBlank;

public record AuthorCreateDTO(
        @NotBlank(message = "El título no puede estar vacío")
        String name
) {
}
