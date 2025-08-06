package com.academica.academica.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "profesores")
public class Profesores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    // constructor, getters, and setters
    public Profesores() {
    }
    public Profesores(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //prueba de commit
}