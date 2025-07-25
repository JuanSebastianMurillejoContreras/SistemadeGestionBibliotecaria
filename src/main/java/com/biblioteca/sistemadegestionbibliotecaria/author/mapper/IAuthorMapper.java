package com.biblioteca.sistemadegestionbibliotecaria.author.mapper;

import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.dto.out.AuthorResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.entity.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAuthorMapper {

    //DTO -> DTO
    AuthorCreateDTO authorRequestDTOToAuthorCreateDTO(AuthorRequestDTO authorRequestDTO);
    AuthorResponseDTO authorDTOToAuthorResponseDTO(AuthorDTO authorDTO);

    //DTO -> Entity
    AuthorEntity authorCreateDTOToAuthorEntity(AuthorCreateDTO authorCreateDTO);

    //Entity -> Author
    AuthorDTO authorEntityToAuthorDTO(AuthorEntity authorEntity);

}
