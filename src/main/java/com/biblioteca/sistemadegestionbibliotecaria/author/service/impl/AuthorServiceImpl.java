package com.biblioteca.sistemadegestionbibliotecaria.author.service.impl;

import com.biblioteca.sistemadegestionbibliotecaria.author.constants.AuthorErrorMessage;
import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.entity.AuthorEntity;
import com.biblioteca.sistemadegestionbibliotecaria.author.exception.AuthorException;
import com.biblioteca.sistemadegestionbibliotecaria.author.mapper.IAuthorMapper;
import com.biblioteca.sistemadegestionbibliotecaria.author.repo.IAuthorRepo;
import com.biblioteca.sistemadegestionbibliotecaria.author.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService {

    private final IAuthorRepo authorRepo;
    private final IAuthorMapper authorMapper;

    @Override
    public AuthorDTO addAuthor(AuthorCreateDTO authorCreateDTO) {

        if(authorRepo.existsByName(authorCreateDTO.name()))
            throw new AuthorException(
                    AuthorErrorMessage.AUTOR_DOES_NOT_EXIST + ": " + authorCreateDTO.name());

        AuthorEntity authorEntity = authorMapper.authorCreateDTOToAuthorEntity(authorCreateDTO);
        AuthorEntity authorEntitySave = authorRepo.save(authorEntity);

        return authorMapper.authorEntityToAuthorDTO(authorEntitySave);
    }
}
