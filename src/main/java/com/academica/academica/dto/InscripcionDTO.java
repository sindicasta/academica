package com.academica.academica.dto;

public class InscripcionDTO {
    private Integer id;
    private Integer estudianteId;
    private String estudianteNombre;
    private Integer asignacionId;
    private String cursoNombre;
    private String profesorNombre;

    // Constructor vacío
    public InscripcionDTO() {}

    // Constructor con parámetros
    public InscripcionDTO(Integer id, Integer estudianteId, String estudianteNombre,
                          Integer asignacionId, String cursoNombre, String profesorNombre) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.estudianteNombre = estudianteNombre;
        this.asignacionId = asignacionId;
        this.cursoNombre = cursoNombre;
        this.profesorNombre = profesorNombre;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getEstudianteId() {
        return estudianteId;
    }
    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }
    public String getEstudianteNombre() {
        return estudianteNombre;
    }
    public void setEstudianteNombre(String estudianteNombre) {
        this.estudianteNombre = estudianteNombre;
    }
    public Integer getAsignacionId() {
        return asignacionId;
    }
    public void setAsignacionId(Integer asignacionId) {
        this.asignacionId = asignacionId;
    }
    public String getCursoNombre() {
        return cursoNombre;
    }
    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }
    public String getProfesorNombre() {
        return profesorNombre;
    }
    public void setProfesorNombre(String profesorNombre) {
        this.profesorNombre = profesorNombre;
    }
}