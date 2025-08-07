package com.academica.academica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.academica.academica.entities.Profesores;
import java.util.List;

@Repository
public interface ProfesoresRepository extends JpaRepository<Profesores, Integer> {

    List<Profesores> findByNombreContainingIgnoreCase(String nombre);

    List<Profesores> findByApellidoContainingIgnoreCase(String apellido);
}
