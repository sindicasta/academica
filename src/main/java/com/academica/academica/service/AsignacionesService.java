package com.academica.academica.service;

import com.academica.academica.entities.Asignaciones;
import com.academica.academica.entities.Cursos;
import com.academica.academica.entities.Profesores;
import com.academica.academica.repository.AsignacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignacionesService {

    @Autowired
    private AsignacionesRepository asignacionesRepository;

    public List<Asignaciones> listarTodas() {
        return asignacionesRepository.findAll();
    }

    public Optional<Asignaciones> obtenerPorId(Integer id) {
        return asignacionesRepository.findById(id);
    }

    public Asignaciones guardar(Asignaciones asignacion) {
        return asignacionesRepository.save(asignacion);
    }

    public void eliminar(Integer id) {
        asignacionesRepository.deleteById(id);
    }

    public List<Asignaciones> buscarPorProfesor(Profesores profesor) {
        return asignacionesRepository.findByProfesor(profesor);
    }

    public List<Asignaciones> buscarPorCurso(Cursos curso) {
        return asignacionesRepository.findByCurso(curso);
    }

    public Asignaciones obtenerPorProfesorYCurso(Profesores profesor, Cursos curso) {
        return asignacionesRepository.findByProfesorAndCurso(profesor, curso);
    }

    public boolean existe(Profesores profesor, Cursos curso) {
        return asignacionesRepository.existsByProfesorAndCurso(profesor, curso);
    }
}

