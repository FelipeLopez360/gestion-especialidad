package com.felipelopez.gestion_especialidad.repository;

import com.felipelopez.gestion_especialidad.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
