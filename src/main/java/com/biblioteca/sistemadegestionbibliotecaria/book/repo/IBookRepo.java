package com.biblioteca.sistemadegestionbibliotecaria.book.repo;

import com.biblioteca.sistemadegestionbibliotecaria.book.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepo extends JpaRepository<BookEntity, Long> {

    boolean existsByIsbn(String isbn);
    boolean existsByTitle(String title);

}
