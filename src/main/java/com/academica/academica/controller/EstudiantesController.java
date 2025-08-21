package com.academica.academica.controller;

import com.academica.academica.dto.EstudianteDTO;
import com.academica.academica.entities.Estudiantes;
import com.academica.academica.service.EstudiantesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudiantesController {

    private final EstudiantesService service;

    public EstudiantesController(EstudiantesService service) {
        this.service = service;
    }

    @GetMapping
    public List<EstudianteDTO> getAll(@RequestParam(required = false) String apellido) {
        if (apellido != null) {
            return service.findByApellido(apellido);
        }
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estudiantes create(@RequestBody Estudiantes estudiante) {
        return service.save(estudiante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}