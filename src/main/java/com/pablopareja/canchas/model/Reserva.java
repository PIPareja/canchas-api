package com.pablopareja.canchas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreUsuario;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    @ManyToOne
    @JoinColumn(name = "cancha_id")
    private Cancha cancha;
}