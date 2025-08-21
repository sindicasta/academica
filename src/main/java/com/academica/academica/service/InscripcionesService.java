package com.academica.academica.service;

import com.academica.academica.dto.InscripcionDTO;
import com.academica.academica.entities.Inscripciones;
import com.academica.academica.repository.InscripcionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InscripcionesService {

    private final InscripcionesRepository repository;

    public InscripcionesService(InscripcionesRepository repository) {
        this.repository = repository;
    }

    public List<InscripcionDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<InscripcionDTO> getById(Integer id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    // Filtro por estudiante
    public List<InscripcionDTO> findByEstudianteId(Integer estudianteId) {
        return repository.findByEstudianteId(estudianteId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Filtro por asignación
    public List<InscripcionDTO> findByAsignacionId(Integer asignacionId) {
        return repository.findByAsignacionId(asignacionId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Inscripciones save(Inscripciones inscripcion) {
        return repository.save(inscripcion);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private InscripcionDTO convertToDTO(Inscripciones inscripcion) {
        return new InscripcionDTO(
                inscripcion.getId(),
                inscripcion.getEstudiante().getId(),
                inscripcion.getEstudiante().getNombre() + " " + inscripcion.getEstudiante().getApellido(),
                inscripcion.getAsignacion().getId(),
                inscripcion.getAsignacion().getCurso().getNombre(),
                inscripcion.getAsignacion().getProfesor().getNombre() + " " + inscripcion.getAsignacion().getProfesor().getApellido()
        );
    }
}