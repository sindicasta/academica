package com.academica.academica.controller;

import com.academica.academica.entities.Cursos;
import com.academica.academica.service.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursosController {

    @Autowired
    private CursosService cursosService;

    @GetMapping
    public List<Cursos> listar() {
        return cursosService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cursos> obtener(@PathVariable Integer id) {
        return cursosService.obtenerPorId(id);
    }

    @PostMapping
    public Cursos crear(@RequestBody Cursos curso) {
        return cursosService.guardar(curso);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        cursosService.eliminar(id);
    }

    @GetMapping("/buscar")
    public Cursos buscarPorNombre(@RequestParam String nombre) {
        return cursosService.buscarPorNombre(nombre);
    }
}

