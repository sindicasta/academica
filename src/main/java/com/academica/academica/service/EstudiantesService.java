package com.academica.academica.service;

import com.academica.academica.dto.EstudianteDTO;
import com.academica.academica.entities.Estudiantes;
import com.academica.academica.repository.EstudiantesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudiantesService {

    private final EstudiantesRepository repository;

    public EstudiantesService(EstudiantesRepository repository) {
        this.repository = repository;
    }

    public List<EstudianteDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<EstudianteDTO> getById(Integer id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    // Filtro por apellido
    public List<EstudianteDTO> findByApellido(String apellido) {
        return repository.findByApellido(apellido)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Estudiantes save(Estudiantes estudiante) {
        return repository.save(estudiante);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private EstudianteDTO convertToDTO(Estudiantes estudiante) {
        return new EstudianteDTO(estudiante.getId(), estudiante.getNombre(), estudiante.getApellido());
    }
}