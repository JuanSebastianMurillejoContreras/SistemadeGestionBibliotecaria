package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.repo;

import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepo extends JpaRepository<AuthorEntity, Long> {
    boolean existsByName(String name);
}
