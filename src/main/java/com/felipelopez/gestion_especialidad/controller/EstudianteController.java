package com.felipelopez.gestion_especialidad.controller;

import com.felipelopez.gestion_especialidad.exception.ResourceNotFoundException;
import com.felipelopez.gestion_especialidad.model.Estudiante;
import com.felipelopez.gestion_especialidad.service.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@AllArgsConstructor
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerTodosLosEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Long id) {
        try {
            Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id);
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.crearEstudiante(estudiante);
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        try {
            Estudiante estudianteExistente = estudianteService.obtenerEstudiantePorId(id);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Estudiante estudianteActualizado = estudianteService.actualizarEstudiante(id, estudiante);
        return new ResponseEntity<>(estudianteActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}