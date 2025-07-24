package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.controller;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.dto.input.LibraryCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.dto.input.LibraryRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.dto.out.LibraryResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.mapper.ILibraryMapper;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.service.ILibraryService;
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
        public ResponseEntity<LibraryResponseDTO> createLibrary(@RequestBody LibraryRequestDTO libraryRequestDTO) {

        LibraryCreateDTO libraryCreateDTO = libraryMapper.LibraryRequestDTOToLibraryCreateDTO(libraryRequestDTO);
        LibraryCreateDTO addLibrary = libraryService.createLibrary(libraryCreateDTO);
        LibraryResponseDTO libraryResponseDTO = libraryMapper.LibraryCreateDTOToLibraryResponseDTO(addLibrary);

        return ResponseEntity.status(HttpStatus.CREATED).body(libraryResponseDTO);
    }


}
