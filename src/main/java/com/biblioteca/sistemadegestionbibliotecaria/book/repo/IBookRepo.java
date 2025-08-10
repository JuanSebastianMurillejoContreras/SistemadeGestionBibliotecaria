package com.biblioteca.sistemadegestionbibliotecaria.book.repo;

import com.biblioteca.sistemadegestionbibliotecaria.author.entity.AuthorEntity;
import com.biblioteca.sistemadegestionbibliotecaria.book.entity.BookEntity;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookRepo extends JpaRepository<BookEntity, Long> {

    boolean existsByIsbn(String isbn);
    boolean existsByTitle(String title);

        @Query("""
        SELECT b FROM BookEntity b
        WHERE (:libraryId IS NULL OR b.library.id = :libraryId)
        AND (:authorId IS NULL OR b.author.id = :authorId)
        AND (:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%')))
        """)
        List<BookEntity> searchBooks(
                @Param("libraryId") Long libraryId,
                @Param("authorId") Long authorId,
                @Param("title") String title
        );
}