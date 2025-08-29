package com.biblioteca.sistemadegestionbibliotecaria.author.service.impl;

import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.entity.AuthorEntity;
import com.biblioteca.sistemadegestionbibliotecaria.author.mapper.IAuthorMapper;
import com.biblioteca.sistemadegestionbibliotecaria.author.repo.IAuthorRepo;
import com.biblioteca.sistemadegestionbibliotecaria.author.service.IAuthorService;
import com.biblioteca.sistemadegestionbibliotecaria.book.exception.BookException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService {

    private final IAuthorRepo authorRepo;
    private final IAuthorMapper authorMapper;

    @Override
    public AuthorDTO addAuthor(AuthorCreateDTO authorCreateDTO) {

        if (authorCreateDTO.name() == null){
            throw new IllegalArgumentException("El nombre del autor no puede ser nulo");
        }

        if (authorCreateDTO.name().isEmpty()){
            throw new IllegalArgumentException("El nombre del autor no puede estar vacío");
        }

        AuthorEntity authorEntity = authorMapper.authorCreateDTOToAuthorEntity(authorCreateDTO);

        authorRepo.save(authorEntity);

        return authorMapper.authorEntityToAuthorDTO(authorEntity);
    }

}
