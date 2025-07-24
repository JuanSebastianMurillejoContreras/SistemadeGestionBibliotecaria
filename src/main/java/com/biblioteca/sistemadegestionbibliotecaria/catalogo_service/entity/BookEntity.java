package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.entity;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.entity.LibraryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_libro")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(unique = true, nullable = false)
    private String isbn;

    @ManyToOne
    @JoinColumn(nullable = false)
    private AuthorEntity author;

    @ManyToOne
    @JoinColumn(nullable = false)
    private LibraryEntity biblioteca;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(titulo, that.titulo) && Objects.equals(isbn, that.isbn) && Objects.equals(author, that.author) && Objects.equals(biblioteca, that.biblioteca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, isbn, author, biblioteca);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author=" + author +
                ", biblioteca=" + biblioteca +
                '}';
    }
}
