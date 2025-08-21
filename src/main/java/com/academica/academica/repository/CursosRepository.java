package com.academica.academica.repository;

import com.academica.academica.entities.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Integer> {
    // Buscar cursos por nombre
    List<Cursos> findByNombreContainingIgnoreCase(String nombre);
}