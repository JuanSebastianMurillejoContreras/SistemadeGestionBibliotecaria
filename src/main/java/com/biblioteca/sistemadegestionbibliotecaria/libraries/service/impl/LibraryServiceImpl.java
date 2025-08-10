package com.biblioteca.sistemadegestionbibliotecaria.libraries.service.impl;

import com.biblioteca.sistemadegestionbibliotecaria.libraries.constants.LibraryErrorMessage;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.dto.input.LibraryCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.dto.input.LibraryDTO;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.entity.LibraryEntity;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.exception.LibraryException;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.mapper.ILibraryMapper;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.repo.ILibraryRepo;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.service.ILibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements ILibraryService {

    private final ILibraryRepo libraryRepo;
    private final ILibraryMapper libraryMapper;

    @Override
    public LibraryDTO createLibrary(LibraryCreateDTO libraryCreateDTO) {

        final boolean existsLibrary = libraryRepo.existsByName(libraryCreateDTO.name());
        if (existsLibrary)
            throw new LibraryException(LibraryErrorMessage.LIBRARY_ALREDY_REGISTERED + ": " + libraryCreateDTO.name());


        if (libraryRepo.existsByName(libraryCreateDTO.name()))
            throw new LibraryException(LibraryErrorMessage.LIBRARY_ALREDY_REGISTERED + ": " + libraryCreateDTO.name());


        LibraryEntity libraryEntity = libraryMapper.libraryEntityToLibraryCreateDTO(libraryCreateDTO);
        LibraryEntity libraryEntitySave = libraryRepo.save(libraryEntity);

        return libraryMapper.libraryEntityToLibraryDTO(libraryEntitySave);
    }
}
