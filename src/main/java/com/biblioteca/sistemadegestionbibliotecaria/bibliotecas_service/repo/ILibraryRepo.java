package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.repo;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibraryRepo extends JpaRepository<LibraryEntity, Long> {

    boolean existsByName(String name);

}
