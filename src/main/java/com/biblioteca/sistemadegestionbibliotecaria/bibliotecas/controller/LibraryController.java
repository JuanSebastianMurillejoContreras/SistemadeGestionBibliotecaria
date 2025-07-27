package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.controller;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.input.LibraryCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.input.LibraryDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.input.LibraryRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.out.LibraryResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.mapper.ILibraryMapper;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.service.ILibraryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/libraries")
@RequiredArgsConstructor
public class LibraryController {

    private final ILibraryService libraryService;
    private final ILibraryMapper libraryMapper;

    @PostMapping
        public ResponseEntity<LibraryResponseDTO> createLibrary(@RequestBody @Valid LibraryRequestDTO libraryRequestDTO) {

        LibraryCreateDTO libraryCreateDTO = libraryMapper.LibraryRequestDTOToLibraryCreateDTO(libraryRequestDTO);
        LibraryDTO addLibrary = libraryService.createLibrary(libraryCreateDTO);
        LibraryResponseDTO libraryResponseDTO = libraryMapper.LibraryDTOToLibraryResponseDTO(addLibrary);

        return ResponseEntity.status(HttpStatus.CREATED).body(libraryResponseDTO);
    }

}
