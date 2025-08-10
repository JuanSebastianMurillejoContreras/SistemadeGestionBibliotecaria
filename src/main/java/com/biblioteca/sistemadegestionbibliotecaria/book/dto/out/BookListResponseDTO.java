package com.biblioteca.sistemadegestionbibliotecaria.book.dto.out;

import java.util.List;

public record BookListResponseDTO(
        List<BookResponseDTO> bookResponseDTOList
) {
}
