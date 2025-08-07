package com.academica.academica.controller;

import com.academica.academica.entities.Estudiantes;
import com.academica.academica.service.EstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudiantesController {

    @Autowired
    private EstudiantesService estudiantesService;

    @GetMapping
    public List<Estudiantes> listar() {
        return estudiantesService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Estudiantes> obtener(@PathVariable Integer id) {
        return estudiantesService.obtenerPorId(id);
    }

    @PostMapping
    public Estudiantes crear(@RequestBody Estudiantes estudiante) {
        return estudiantesService.guardar(estudiante);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        estudiantesService.eliminar(id);
    }

    @GetMapping("/buscar-nombre")
    public List<Estudiantes> buscarPorNombre(@RequestParam String nombre) {
        return estudiantesService.buscarPorNombre(nombre);
    }

    @GetMapping("/buscar-apellido")
    public List<Estudiantes> buscarPorApellido(@RequestParam String apellido) {
        return estudiantesService.buscarPorApellido(apellido);
    }
}

