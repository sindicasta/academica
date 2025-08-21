package com.academica.academica.dto;

public class AsignacionDTO {
    private Integer id;
    private Integer profesorId;
    private String profesorNombre;
    private Integer cursoId;
    private String cursoNombre;

    // Constructor vacío
    public AsignacionDTO() {}

    // Constructor con parámetros
    public AsignacionDTO(Integer id, Integer profesorId, String profesorNombre,
                         Integer cursoId, String cursoNombre) {
        this.id = id;
        this.profesorId = profesorId;
        this.profesorNombre = profesorNombre;
        this.cursoId = cursoId;
        this.cursoNombre = cursoNombre;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getProfesorId() {
        return profesorId;
    }
    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }
    public String getProfesorNombre() {
        return profesorNombre;
    }
    public void setProfesorNombre(String profesorNombre) {
        this.profesorNombre = profesorNombre;
    }
    public Integer getCursoId() {
        return cursoId;
    }
    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }
    public String getCursoNombre() {
        return cursoNombre;
    }
    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }
}