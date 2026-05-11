package com.pablopareja.canchas.repository;

import com.pablopareja.canchas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByCanchaIdAndFechaInicioBetween(
            Long canchaId,
            LocalDateTime inicio,
            LocalDateTime fin
    );
}