package com.academica.academica.controller;

import com.academica.academica.entities.Profesores;
import com.academica.academica.service.ProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesores")
public class ProfesoresController {

    @Autowired
    private ProfesoresService profesoresService;

    @GetMapping
    public List<Profesores> listar() {
        return profesoresService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Profesores> obtener(@PathVariable Integer id) {
        return profesoresService.obtenerPorId(id);
    }

    @PostMapping
    public Profesores crear(@RequestBody Profesores profesor) {
        return profesoresService.guardar(profesor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        profesoresService.eliminar(id);
    }

    @GetMapping("/buscar-nombre")
    public List<Profesores> buscarPorNombre(@RequestParam String nombre) {
        return profesoresService.buscarPorNombre(nombre);
    }

    @GetMapping("/buscar-apellido")
    public List<Profesores> buscarPorApellido(@RequestParam String apellido) {
        return profesoresService.buscarPorApellido(apellido);
    }
}
