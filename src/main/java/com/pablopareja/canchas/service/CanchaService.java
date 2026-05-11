package com.pablopareja.canchas.service;

import com.pablopareja.canchas.model.Cancha;
import com.pablopareja.canchas.repository.CanchaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CanchaService {

    private final CanchaRepository canchaRepository;

    public List<Cancha> obtenerTodas() {
        return canchaRepository.findAll();
    }

    public Cancha obtenerPorId(Long id) {
        return canchaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cancha no encontrada"));
    }

    public Cancha crear(Cancha cancha) {
        return canchaRepository.save(cancha);
    }

    public Cancha actualizar(Long id, Cancha datos) {
        Cancha cancha = obtenerPorId(id);
        cancha.setNombre(datos.getNombre());
        cancha.setTipo(datos.getTipo());
        cancha.setDisponible(datos.isDisponible());
        return canchaRepository.save(cancha);
    }

    public void eliminar(Long id) {
        canchaRepository.deleteById(id);
    }
}