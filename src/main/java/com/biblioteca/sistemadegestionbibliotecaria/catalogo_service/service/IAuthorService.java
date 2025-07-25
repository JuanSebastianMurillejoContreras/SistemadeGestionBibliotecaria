package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.service;

import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input.AuthorCreateDTO;

public interface IAuthorService {

    AuthorCreateDTO addAuthor(AuthorCreateDTO authorCreateDTO);

}
