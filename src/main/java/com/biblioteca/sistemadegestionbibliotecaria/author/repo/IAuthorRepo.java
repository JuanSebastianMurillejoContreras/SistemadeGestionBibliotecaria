package com.biblioteca.sistemadegestionbibliotecaria.author.repo;

import com.biblioteca.sistemadegestionbibliotecaria.author.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepo extends JpaRepository<AuthorEntity, Long> {
    boolean existsByName(String name);
}
