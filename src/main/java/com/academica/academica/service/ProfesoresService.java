package com.academica.academica.service;

import com.academica.academica.dto.ProfesoresDTO;
import com.academica.academica.entities.Profesores;
import com.academica.academica.repository.ProfesoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesoresService {

    private final ProfesoresRepository repository;

    public ProfesoresService(ProfesoresRepository repository) {
        this.repository = repository;
    }

    public List<ProfesoresDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProfesoresDTO> getById(Integer id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    // Filtro por apellido
    public List<ProfesoresDTO> findByApellido(String apellido) {
        return repository.findByApellido(apellido)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Métodos CRUD (con Entity)
    public Profesores save(Profesores profesor) {
        return repository.save(profesor);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    // Conversión Entity → DTO
    private ProfesoresDTO convertToDTO(Profesores profesor) {
        return new ProfesoresDTO(profesor.getId(), profesor.getNombre(), profesor.getApellido());
    }
}