package com.pablopareja.canchas.controller;

import com.pablopareja.canchas.model.Cancha;
import com.pablopareja.canchas.service.CanchaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canchas")
@RequiredArgsConstructor
public class CanchaController {

    private final CanchaService canchaService;

    @GetMapping
    public List<Cancha> obtenerTodas() {
        return canchaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cancha> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(canchaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cancha> crear(@RequestBody Cancha cancha) {
        return ResponseEntity.ok(canchaService.crear(cancha));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cancha> actualizar(@PathVariable Long id, @RequestBody Cancha datos) {
        return ResponseEntity.ok(canchaService.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        canchaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}