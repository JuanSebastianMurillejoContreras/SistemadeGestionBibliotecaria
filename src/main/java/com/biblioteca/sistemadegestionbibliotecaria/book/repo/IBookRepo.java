package com.biblioteca.sistemadegestionbibliotecaria.book.repo;

import com.biblioteca.sistemadegestionbibliotecaria.book.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookRepo extends JpaRepository<BookEntity, Long> {

    boolean existsByIsbn(String isbn);
    boolean existsByTitle(String title);
    List<BookEntity> findByLibraryId(Long libraryId);
    List<BookEntity> findByAuthorId(Long authorId);
    List<BookEntity> findByTitleContainingIgnoreCaseOrAuthor_NameContainingIgnoreCase(String title, String authorName);

}
