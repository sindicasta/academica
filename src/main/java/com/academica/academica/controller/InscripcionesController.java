package com.academica.academica.controller;

import com.academica.academica.entities.Inscripciones;
import com.academica.academica.entities.Estudiantes;
import com.academica.academica.entities.Asignaciones;
import com.academica.academica.service.InscripcionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionesController {

    @Autowired
    private InscripcionesService inscripcionesService;

    @GetMapping
    public List<Inscripciones> listar() {
        return inscripcionesService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Inscripciones> obtener(@PathVariable Integer id) {
        return inscripcionesService.obtenerPorId(id);
    }

    @PostMapping
    public Inscripciones crear(@RequestBody Inscripciones inscripcion) {
        return inscripcionesService.guardar(inscripcion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        inscripcionesService.eliminar(id);
    }

    @GetMapping("/por-estudiante")
    public List<Inscripciones> porEstudiante(@RequestBody Estudiantes estudiante) {
        return inscripcionesService.buscarPorEstudiante(estudiante);
    }

    @GetMapping("/por-asignacion")
    public List<Inscripciones> porAsignacion(@RequestBody Asignaciones asignacion) {
        return inscripcionesService.buscarPorAsignacion(asignacion);
    }

    @PostMapping("/existe")
    public boolean existe(@RequestBody Inscripciones inscripcion) {
        return inscripcionesService.existe(inscripcion.getEstudiante(), inscripcion.getAsignacion());
    }
}
