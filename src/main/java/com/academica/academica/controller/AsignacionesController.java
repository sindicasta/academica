package com.academica.academica.controller;

import com.academica.academica.dto.AsignacionDTO;
import com.academica.academica.entities.Asignaciones;
import com.academica.academica.service.AsignacionesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionesController {

    private final AsignacionesService service;

    public AsignacionesController(AsignacionesService service) {
        this.service = service;
    }

    @GetMapping
    public List<AsignacionDTO> getAll(@RequestParam(required = false) Integer profesorId) {
        if (profesorId != null) {
            return service.findByProfesorId(profesorId);
        }
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionDTO> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Asignaciones create(@RequestBody Asignaciones asignacion) {
        return service.save(asignacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}