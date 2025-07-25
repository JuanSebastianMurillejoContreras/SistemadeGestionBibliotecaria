package com.biblioteca.sistemadegestionbibliotecaria.author.service;

import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorCreateDTO;

public interface IAuthorService {

    AuthorCreateDTO addAuthor(AuthorCreateDTO authorCreateDTO);

}
