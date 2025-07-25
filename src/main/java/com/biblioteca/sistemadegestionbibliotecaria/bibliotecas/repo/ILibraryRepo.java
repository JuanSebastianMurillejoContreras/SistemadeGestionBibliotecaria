package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.repo;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibraryRepo extends JpaRepository<LibraryEntity, Long> {

    boolean existsByName(String name);

}
