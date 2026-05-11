package com.pablopareja.canchas.service;

import com.pablopareja.canchas.model.Cancha;
import com.pablopareja.canchas.model.Reserva;
import com.pablopareja.canchas.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final CanchaService canchaService;

    public List<Reserva> obtenerTodas() {
        return reservaRepository.findAll();
    }

    public Reserva crear(Reserva reserva) {
        Cancha cancha = canchaService.obtenerPorId(reserva.getCancha().getId());

        if (!cancha.isDisponible()) {
            throw new RuntimeException("La cancha no está disponible");
        }

        List<Reserva> conflictos = reservaRepository.findByCanchaIdAndFechaInicioBetween(
                cancha.getId(),
                reserva.getFechaInicio(),
                reserva.getFechaFin()
        );

        if (!conflictos.isEmpty()) {
            throw new RuntimeException("La cancha ya tiene una reserva en ese horario");
        }

        return reservaRepository.save(reserva);
    }

    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }

    public Reserva obtenerPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    public Reserva actualizar(Long id, Reserva datos) {
        Reserva reserva = obtenerPorId(id);

        List<Reserva> conflictos = reservaRepository.findByCanchaIdAndFechaInicioBetween(
                reserva.getCancha().getId(),
                datos.getFechaInicio(),
                datos.getFechaFin()
        );

        boolean hayConflicto = conflictos.stream()
                .anyMatch(r -> !r.getId().equals(id));

        if (hayConflicto) {
            throw new RuntimeException("La cancha ya tiene una reserva en ese horario");
        }

        reserva.setNombreUsuario(datos.getNombreUsuario());
        reserva.setFechaInicio(datos.getFechaInicio());
        reserva.setFechaFin(datos.getFechaFin());
        return reservaRepository.save(reserva);
    }
}