package com.biblioteca.sistemadegestionbibliotecaria.author.service;

import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorDTO;

public interface IAuthorService {

    AuthorDTO addAuthor(AuthorCreateDTO authorCreateDTO);

}
