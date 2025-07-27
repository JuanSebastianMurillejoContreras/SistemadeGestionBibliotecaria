package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.service.impl;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.constants.LibraryErrorMessage;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.input.LibraryCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.input.LibraryDTO;
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

    @Override
    public LibraryDTO createLibrary(LibraryCreateDTO libraryCreateDTO) {

        if (libraryRepo.existsByName(libraryCreateDTO.name()))
            throw new LibraryException(LibraryErrorMessage.LIBRARY_ALREDY_REGISTERED + ": " + libraryCreateDTO.name());

        LibraryEntity libraryEntity = libraryMapper.libraryEntityToLibraryCreateDTO(libraryCreateDTO);
        LibraryEntity libraryEntitySave = libraryRepo.save(libraryEntity);

        return libraryMapper.libraryEntityToLibraryDTO(libraryEntitySave);
    }
}
