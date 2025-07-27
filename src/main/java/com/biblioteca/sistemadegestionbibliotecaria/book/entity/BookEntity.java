package com.biblioteca.sistemadegestionbibliotecaria.book.entity;

import com.biblioteca.sistemadegestionbibliotecaria.author.entity.AuthorEntity;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.entity.LibraryEntity;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.entity.ReservationEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
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

    @Column(unique = true, nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private String isbn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "library_id")
    private LibraryEntity library;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book", nullable = false)
    private List<ReservationEntity> LstReservations;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(isbn, that.isbn) && Objects.equals(author, that.author) && Objects.equals(library, that.library);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isbn, author, library);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", titulo='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author=" + author +
                ", biblioteca=" + library +
                '}';
    }
}
