package com.academica.academica.service;

import com.academica.academica.entities.Inscripciones;
import com.academica.academica.entities.Estudiantes;
import com.academica.academica.entities.Asignaciones;
import com.academica.academica.repository.InscripcionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionesService {

    @Autowired
    private InscripcionesRepository inscripcionesRepository;

    public List<Inscripciones> listarTodas() {
        return inscripcionesRepository.findAll();
    }

    public Optional<Inscripciones> obtenerPorId(Integer id) {
        return inscripcionesRepository.findById(id);
    }

    public Inscripciones guardar(Inscripciones inscripcion) {
        return inscripcionesRepository.save(inscripcion);
    }

    public void eliminar(Integer id) {
        inscripcionesRepository.deleteById(id);
    }

    public List<Inscripciones> buscarPorEstudiante(Estudiantes estudiante) {
        return inscripcionesRepository.findByEstudiante(estudiante);
    }

    public List<Inscripciones> buscarPorAsignacion(Asignaciones asignacion) {
        return inscripcionesRepository.findByAsignacion(asignacion);
    }

    public boolean existe(Estudiantes estudiante, Asignaciones asignacion) {
        return inscripcionesRepository.existsByEstudianteAndAsignacion(estudiante, asignacion);
    }

    public Inscripciones obtenerPorEstudianteYAsignacion(Estudiantes estudiante, Asignaciones asignacion) {
        return inscripcionesRepository.findByEstudianteAndAsignacion(estudiante, asignacion);
    }
}
