package com.felipelopez.gestion_especialidad.service.impl;


import com.felipelopez.gestion_especialidad.model.Estudiante;
import com.felipelopez.gestion_especialidad.repository.EstudianteRepository;
import com.felipelopez.gestion_especialidad.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {


    private final EstudianteRepository estudianteRepository;

    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id) {
        return estudianteRepository.findById(id).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    @Override
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante actualizarEstudiante(Long id, Estudiante estudianteActualizado) {
        Estudiante estudiante = obtenerEstudiantePorId(id);
        estudiante.setNombre(estudianteActualizado.getNombre());
        estudiante.setEspecialidad(estudianteActualizado.getEspecialidad());
        estudiante.setGrado(estudianteActualizado.getGrado());
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        Estudiante estudiante = obtenerEstudiantePorId(id);
        estudianteRepository.delete(estudiante);
    }
}
