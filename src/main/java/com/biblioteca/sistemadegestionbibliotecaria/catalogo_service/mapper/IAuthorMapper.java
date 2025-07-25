package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.mapper;

import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input.AuthorCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input.AuthorRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.out.AuthorResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.entity.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAuthorMapper {

    //DTO -> DTO
    AuthorCreateDTO authorRequestDTOToAuthorCreateDTO(AuthorRequestDTO authorRequestDTO);
    AuthorResponseDTO authorCreateDTOToAuthorResponseDTO(AuthorCreateDTO authorCreateDTO);

    //DTO -> Entity
    AuthorEntity authorCreateDTOToAuthorEntity(AuthorCreateDTO authorCreateDTO);

    //Entity -> Author
    AuthorCreateDTO authorEntityToAuthorCreateDTO(AuthorEntity authorEntity);

}
