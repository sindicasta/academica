package com.academica.academica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.academica.academica.entities.Estudiantes;
import java.util.List;

@Repository
public interface EstudiantesRepository extends JpaRepository<Estudiantes, Integer> {

    List<Estudiantes> findByNombreContainingIgnoreCase(String nombre);

    List<Estudiantes> findByApellidoContainingIgnoreCase(String apellido);
}
