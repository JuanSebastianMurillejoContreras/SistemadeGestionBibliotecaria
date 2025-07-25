package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.repo;

import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IBookRepo extends JpaRepository<BookEntity, Long> {

    boolean existsByIsbn(String isbn);
    boolean existsByTitle(String title);

    @Query("SELECT b FROM BookEntity b JOIN FETCH b.author JOIN FETCH b.library WHERE b.id = :id")
    Optional<BookEntity> findByIdWithAuthorAndLibrary(@Param("id") Long id);


}
