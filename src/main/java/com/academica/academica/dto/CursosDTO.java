package com.academica.academica.dto;

public class CursosDTO {
    private Integer id;
    private String nombre;

    // Constructor
    public CursosDTO() {}

    public CursosDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
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
}