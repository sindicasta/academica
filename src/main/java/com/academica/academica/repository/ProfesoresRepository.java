package com.academica.academica.repository;

import com.academica.academica.entities.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesoresRepository extends JpaRepository<Profesores, Integer> {
    // Buscar profesores por apellido
    List<Profesores> findByApellido(String apellido);
}