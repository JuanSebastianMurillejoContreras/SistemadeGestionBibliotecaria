package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.service.impl;

import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input.AuthorCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.entity.AuthorEntity;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.exception.AuthorException;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.mapper.IAuthorMapper;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.repo.IAuthorRepo;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService {

    private final IAuthorRepo authorRepo;
    private final IAuthorMapper authorMapper;


    @Value("${properties.messages.error.author-does-not-exist}")
    public String authorDoesntExistError;

    @Value("${properties.messages.error.name-author-exist}")
    public String authorNameExistError;

    @Override
    public AuthorCreateDTO addAuthor(AuthorCreateDTO authorCreateDTO) {

        if(authorRepo.existsByName(authorCreateDTO.name()))
            throw new AuthorException(String.valueOf(
                    HttpStatus.CONFLICT.value()),
                    authorNameExistError + ": " + authorCreateDTO.name());

        AuthorEntity authorEntity = authorMapper.authorCreateDTOToAuthorEntity(authorCreateDTO);
        AuthorEntity authorEntitySave = authorRepo.save(authorEntity);

        return authorMapper.authorEntityToAuthorCreateDTO(authorEntitySave);
    }
}
