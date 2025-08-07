package com.academica.academica.controller;

import com.academica.academica.entities.Asignaciones;
import com.academica.academica.entities.Cursos;
import com.academica.academica.entities.Profesores;
import com.academica.academica.service.AsignacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionesController {

    @Autowired
    private AsignacionesService asignacionesService;

    @GetMapping
    public List<Asignaciones> listar() {
        return asignacionesService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Asignaciones> obtener(@PathVariable Integer id) {
        return asignacionesService.obtenerPorId(id);
    }

    @PostMapping
    public Asignaciones crear(@RequestBody Asignaciones asignacion) {
        return asignacionesService.guardar(asignacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        asignacionesService.eliminar(id);
    }

    @GetMapping("/por-profesor")
    public List<Asignaciones> porProfesor(@RequestBody Profesores profesor) {
        return asignacionesService.buscarPorProfesor(profesor);
    }

    @GetMapping("/por-curso")
    public List<Asignaciones> porCurso(@RequestBody Cursos curso) {
        return asignacionesService.buscarPorCurso(curso);
    }

    @PostMapping("/existe")
    public boolean existe(@RequestBody Asignaciones asignacion) {
        return asignacionesService.existe(asignacion.getProfesor(), asignacion.getCurso());
    }
}

