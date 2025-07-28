package com.biblioteca.sistemadegestionbibliotecaria.reservation.repo;

import com.biblioteca.sistemadegestionbibliotecaria.reservation.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservationRepo extends JpaRepository<ReservationEntity, Long> {

    List<ReservationEntity> findByIsActiveAndUsuario_Id(Boolean isActive, Long usuarioId);

}
