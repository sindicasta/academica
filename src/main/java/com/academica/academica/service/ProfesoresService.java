package com.academica.academica.service;

import com.academica.academica.entities.Profesores;
import com.academica.academica.repository.ProfesoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesoresService {

    @Autowired
    private ProfesoresRepository profesoresRepository;

    public List<Profesores> listarTodos() {
        return profesoresRepository.findAll();
    }

    public Optional<Profesores> obtenerPorId(Integer id) {
        return profesoresRepository.findById(id);
    }

    public Profesores guardar(Profesores profesor) {
        return profesoresRepository.save(profesor);
    }

    public void eliminar(Integer id) {
        profesoresRepository.deleteById(id);
    }

    public List<Profesores> buscarPorNombre(String nombre) {
        return profesoresRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Profesores> buscarPorApellido(String apellido) {
        return profesoresRepository.findByApellidoContainingIgnoreCase(apellido);
    }
}

