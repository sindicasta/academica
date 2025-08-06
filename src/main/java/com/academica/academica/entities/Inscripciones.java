package com.academica.academica.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "inscripciones", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"estudiante_id", "asignacion_id"})
})
public class Inscripciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiantes estudiante;

    @ManyToOne
    @JoinColumn(name = "asignacion_id", nullable = false)
    private Asignaciones asignacion;

    // Getters y setters
    // ...
}