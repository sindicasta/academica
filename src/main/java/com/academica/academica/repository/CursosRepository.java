package com.academica.academica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.academica.academica.entities.Cursos;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Integer> {

    boolean existsByNombre(String nombre);

    Cursos findByNombre(String nombre);
}

