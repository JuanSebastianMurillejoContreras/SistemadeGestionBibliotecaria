package com.biblioteca.sistemadegestionbibliotecaria.reservation.entity;

import com.biblioteca.sistemadegestionbibliotecaria.book.entity.BookEntity;
import com.biblioteca.sistemadegestionbibliotecaria.usuario.entity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "tb_reserva")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

    @Column(nullable = false)
    private LocalDateTime dateReservation =  LocalDateTime.now();

    @Column(nullable = false)
    private Boolean isActive;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEntity that = (ReservationEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(usuario, that.usuario) && Objects.equals(book, that.book) && Objects.equals(dateReservation, that.dateReservation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, book, dateReservation);
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", book=" + book +
                ", dateReservation=" + dateReservation +
                '}';
    }
}
