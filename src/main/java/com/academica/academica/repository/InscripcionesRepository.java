package com.academica.academica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.academica.academica.entities.Inscripciones;
import com.academica.academica.entities.Estudiantes;
import com.academica.academica.entities.Asignaciones;
import java.util.List;

@Repository
public interface InscripcionesRepository extends JpaRepository<Inscripciones, Integer> {

    List<Inscripciones> findByEstudiante(Estudiantes estudiante);

    List<Inscripciones> findByAsignacion(Asignaciones asignacion);

    boolean existsByEstudianteAndAsignacion(Estudiantes estudiante, Asignaciones asignacion);

    Inscripciones findByEstudianteAndAsignacion(Estudiantes estudiante, Asignaciones asignacion);
}
