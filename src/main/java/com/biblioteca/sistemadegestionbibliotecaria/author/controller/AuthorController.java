package com.biblioteca.sistemadegestionbibliotecaria.author.controller;

import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.dto.out.AuthorResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.mapper.IAuthorMapper;
import com.biblioteca.sistemadegestionbibliotecaria.author.service.IAuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
public class AuthorController {

    private final IAuthorService authorService;
    private final IAuthorMapper authorMapper;

    @PostMapping
    public ResponseEntity<AuthorResponseDTO> addAuthor(@Valid @RequestBody AuthorRequestDTO authorRequestDTO){

        AuthorCreateDTO authorCreateDTO = authorMapper.authorRequestDTOToAuthorCreateDTO(authorRequestDTO);
        AuthorDTO addAuthor = authorService.addAuthor(authorCreateDTO);
        AuthorResponseDTO authorResponseDTO = authorMapper.authorDTOToAuthorResponseDTO(addAuthor);

        return ResponseEntity.status(HttpStatus.CREATED).body(authorResponseDTO);
    }

}
