package com.biblioteca.sistemadegestionbibliotecaria.reservation.repo;

import com.biblioteca.sistemadegestionbibliotecaria.book.entity.BookEntity;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.entity.ReservationEntity;
import com.biblioteca.sistemadegestionbibliotecaria.usuario.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepo extends JpaRepository<ReservationEntity, Long> {

    boolean existsReservationByUsuario(UsuarioEntity usuario);
    boolean existsReservationByUsuarioAndBook(UsuarioEntity usuario, BookEntity book);

}
