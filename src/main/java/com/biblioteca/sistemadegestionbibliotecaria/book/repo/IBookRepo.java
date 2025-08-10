package com.biblioteca.sistemadegestionbibliotecaria.book.repo;

import com.biblioteca.sistemadegestionbibliotecaria.book.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepo extends JpaRepository<BookEntity, Long> {

    boolean existsByIsbn(String isbn);
    boolean existsByTitle(String title);

        @Query("""
        SELECT book FROM BookEntity book
        WHERE (:libraryId IS NULL OR book.library.id = :libraryId)
        AND (:authorId IS NULL OR book.author.id = :authorId)
        AND (:title IS NULL OR LOWER(book.title) LIKE LOWER(CONCAT('%', :title, '%')))
        """)
        Page<BookEntity> searchBooks(
                @Param("libraryId") Long libraryId,
                @Param("authorId") Long authorId,
                @Param("title") String title,
                Pageable pageable
        );
}