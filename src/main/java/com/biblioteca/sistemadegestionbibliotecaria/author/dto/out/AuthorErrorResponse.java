package com.biblioteca.sistemadegestionbibliotecaria.author.dto.out;

import java.util.List;

public record AuthorErrorResponse (
        List<String> message
){}
