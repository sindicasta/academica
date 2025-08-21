package com.academica.academica.service;

import com.academica.academica.dto.CursosDTO;
import com.academica.academica.entities.Cursos;
import com.academica.academica.repository.CursosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursosService {
    private final CursosRepository repository;

    public CursosService(CursosRepository repository) {
        this.repository = repository;
    }

    public List<CursosDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<CursosDTO> getById(Integer id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    // Filtro por nombre
    public List<CursosDTO> findByNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Cursos save(Cursos curso) {
        return repository.save(curso);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private CursosDTO convertToDTO(Cursos curso) {
        return new CursosDTO(curso.getId(), curso.getNombre());
    }
}