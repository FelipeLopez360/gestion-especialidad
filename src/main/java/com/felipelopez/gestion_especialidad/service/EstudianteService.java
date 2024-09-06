package com.felipelopez.gestion_especialidad.service;

import com.felipelopez.gestion_especialidad.model.Estudiante;

import java.util.List;

public interface EstudianteService {
    Estudiante crearEstudiante(Estudiante estudiante);
    List<Estudiante> obtenerTodosLosEstudiantes();
    Estudiante obtenerEstudiantePorId(Long id);
    Estudiante actualizarEstudiante(Long id, Estudiante estudiante);
    void eliminarEstudiante(Long id);
}
