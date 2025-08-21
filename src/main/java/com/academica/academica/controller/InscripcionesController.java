package com.academica.academica.controller;

import com.academica.academica.dto.InscripcionDTO;
import com.academica.academica.entities.Inscripciones;
import com.academica.academica.service.InscripcionesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionesController {

    private final InscripcionesService service;

    public InscripcionesController(InscripcionesService service) {
        this.service = service;
    }

    @GetMapping
    public List<InscripcionDTO> getAll(@RequestParam(required = false) Integer estudianteId) {
        if (estudianteId != null) {
            return service.findByEstudianteId(estudianteId);
        }
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionDTO> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inscripciones create(@RequestBody Inscripciones inscripcion) {
        return service.save(inscripcion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}