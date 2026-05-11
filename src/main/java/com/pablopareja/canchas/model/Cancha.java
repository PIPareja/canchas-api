package com.pablopareja.canchas.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "canchas")
public class Cancha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;
    private boolean disponible;
}