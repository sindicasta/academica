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

    // constructor
    public Inscripciones() {
    }
    public Inscripciones(Estudiantes estudiante, Asignaciones asignacion) {
        this.estudiante = estudiante;
        this.asignacion = asignacion;
    }
    // getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Estudiantes getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(Estudiantes estudiante) {
        this.estudiante = estudiante;
    }
    public Asignaciones getAsignacion() {
        return asignacion;
    }
    public void setAsignacion(Asignaciones asignacion) {
        this.asignacion = asignacion;
    }
    
}