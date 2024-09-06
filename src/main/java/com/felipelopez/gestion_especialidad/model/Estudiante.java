package com.felipelopez.gestion_especialidad.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PRUEBAESTUDIANTE")
@Data
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eid;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String especialidad;

    @Column(nullable = false)
    private String grado;
}
