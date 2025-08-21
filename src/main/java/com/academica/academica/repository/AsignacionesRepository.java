package com.academica.academica.repository;

import com.academica.academica.entities.Asignaciones;
import com.academica.academica.entities.Cursos;
import com.academica.academica.entities.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionesRepository extends JpaRepository<Asignaciones, Integer> {
    List<Asignaciones> findByProfesor(Profesores profesor);
    List<Asignaciones> findByCurso(Cursos curso);

    // Filtros directos por IDs (opcional)
    List<Asignaciones> findByProfesorId(Integer profesorId);
    List<Asignaciones> findByCursoId(Integer cursoId);

    boolean existsByProfesorAndCurso(Profesores profesor, Cursos curso);
}