package com.academica.academica.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaciones", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"profesor_id", "curso_id"})
})
public class Asignaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "profesor_id", nullable = false)
    private Profesores profesor;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Cursos curso;

    // Constructor por defecto
    public Asignaciones() {
    }
    // Constructor con parámetros
    public Asignaciones(Profesores profesor, Cursos curso) {
        this.profesor = profesor;
        this.curso = curso;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Profesores getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }
    public Cursos getCurso() {
        return curso;
    }
    public void setCurso(Cursos curso) {
        this.curso = curso;
    }
}