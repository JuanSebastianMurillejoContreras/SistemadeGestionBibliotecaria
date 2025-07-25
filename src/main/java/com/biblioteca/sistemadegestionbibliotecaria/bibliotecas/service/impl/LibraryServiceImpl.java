package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.service.impl;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.input.LibraryCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.entity.LibraryEntity;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.exception.LibraryException;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.mapper.ILibraryMapper;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.repo.ILibraryRepo;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.service.ILibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements ILibraryService {

    private final ILibraryRepo libraryRepo;
    private final ILibraryMapper libraryMapper;


    @Value("${properties.messages.error.library-does-not-exist}")
    public String libraryDoesntExistError;


    @Value("${properties.messages.error.name-library-exist}")
    public String libraryNameExistError;

    @Override
    public LibraryCreateDTO createLibrary(LibraryCreateDTO libraryCreateDTO) {

        if (libraryRepo.existsByName(libraryCreateDTO.name()))
            throw new LibraryException(String.valueOf(
                    HttpStatus.CONFLICT.value()),
                    libraryNameExistError + ": " + libraryCreateDTO.name());

        LibraryEntity libraryEntity = libraryMapper.libraryEntityToLibraryCreateDTO(libraryCreateDTO);
        LibraryEntity libraryEntitySave = libraryRepo.save(libraryEntity);

        return libraryMapper.libraryEntityToLibraryCreateDTO(libraryEntitySave);
    }
}
