package com.academica.academica.service;

import com.academica.academica.dto.AsignacionDTO;
import com.academica.academica.entities.Asignaciones;
import com.academica.academica.repository.AsignacionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsignacionesService {

    private final AsignacionesRepository repository;

    public AsignacionesService(AsignacionesRepository repository) {
        this.repository = repository;
    }

    public List<AsignacionDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<AsignacionDTO> getById(Integer id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    // Filtro por ID de profesor
    public List<AsignacionDTO> findByProfesorId(Integer profesoresId) {
        return repository.findByProfesorId(profesoresId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Filtro por ID de curso
    public List<AsignacionDTO> findByCursoId(Integer cursoId) {
        return repository.findByCursoId(cursoId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Asignaciones save(Asignaciones asignacion) {
        return repository.save(asignacion);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private AsignacionDTO convertToDTO(Asignaciones asignacion) {
        return new AsignacionDTO(
                asignacion.getId(),
                asignacion.getProfesor().getId(),
                asignacion.getProfesor().getNombre() + " " + asignacion.getProfesor().getApellido(),
                asignacion.getCurso().getId(),
                asignacion.getCurso().getNombre()
        );
    }
}