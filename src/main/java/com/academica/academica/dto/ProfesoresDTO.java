package com.academica.academica.dto;

public class ProfesoresDTO {
    private Integer id;
    private String nombreCompleto;

    public ProfesoresDTO(Integer id, String nombre, String apellido) {
        this.id = id;
        this.nombreCompleto = nombre + " " + apellido;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}