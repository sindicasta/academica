package com.academica.academica.service;

import com.academica.academica.entities.Cursos;
import com.academica.academica.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursosService {

    @Autowired
    private CursosRepository cursosRepository;

    public List<Cursos> listarTodos() {
        return cursosRepository.findAll();
    }

    public Optional<Cursos> obtenerPorId(Integer id) {
        return cursosRepository.findById(id);
    }

    public Cursos guardar(Cursos curso) {
        return cursosRepository.save(curso);
    }

    public void eliminar(Integer id) {
        cursosRepository.deleteById(id);
    }

    public boolean existePorNombre(String nombre) {
        return cursosRepository.existsByNombre(nombre);
    }

    public Cursos buscarPorNombre(String nombre) {
        return cursosRepository.findByNombre(nombre);
    }
}
