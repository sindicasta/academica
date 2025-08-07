package com.academica.academica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.academica.academica.entities.Asignaciones;
import com.academica.academica.entities.Cursos;
import com.academica.academica.entities.Profesores;
import java.util.List;

@Repository
public interface AsignacionesRepository extends JpaRepository<Asignaciones, Integer> {

    List<Asignaciones> findByProfesor(Profesores profesor);

    List<Asignaciones> findByCurso(Cursos curso);

    Asignaciones findByProfesorAndCurso(Profesores profesor, Cursos curso);

    boolean existsByProfesorAndCurso(Profesores profesor, Cursos curso);
}
