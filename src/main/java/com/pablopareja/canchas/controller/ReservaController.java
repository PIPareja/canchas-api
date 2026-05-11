package com.pablopareja.canchas.controller;

import com.pablopareja.canchas.model.Reserva;
import com.pablopareja.canchas.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @GetMapping
    public List<Reserva> obtenerTodas() {
        return reservaService.obtenerTodas();
    }

    @PostMapping
    public ResponseEntity<Reserva> crear(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.crear(reserva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        reservaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizar(@PathVariable Long id, @RequestBody Reserva datos) {
        return ResponseEntity.ok(reservaService.actualizar(id, datos));
    }
}