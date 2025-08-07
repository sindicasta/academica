package com.academica.academica.service;

import com.academica.academica.entities.Estudiantes;
import com.academica.academica.repository.EstudiantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudiantesService {

    @Autowired
    private EstudiantesRepository estudiantesRepository;

    public List<Estudiantes> listarTodos() {
        return estudiantesRepository.findAll();
    }

    public Optional<Estudiantes> obtenerPorId(Integer id) {
        return estudiantesRepository.findById(id);
    }

    public Estudiantes guardar(Estudiantes estudiante) {
        return estudiantesRepository.save(estudiante);
    }

    public void eliminar(Integer id) {
        estudiantesRepository.deleteById(id);
    }

    public List<Estudiantes> buscarPorNombre(String nombre) {
        return estudiantesRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Estudiantes> buscarPorApellido(String apellido) {
        return estudiantesRepository.findByApellidoContainingIgnoreCase(apellido);
    }
}

