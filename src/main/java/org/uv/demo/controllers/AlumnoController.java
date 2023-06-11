/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.demo.controllers;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.uv.demo.dto.DTOAlumnos;
import org.uv.demo.repository.AlumnoRepository;
import org.uv.demo.models.Alumno;

/**
 *
 * @author yacruz
 */
@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    private final AlumnoRepository alumnoRepository;

    public AlumnoController(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @GetMapping
    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Alumno obtenerAlumnoPorId(@PathVariable Long id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con ID: " + id));
    }

    @PostMapping
    public Alumno crearAlumno(@RequestBody DTOAlumnos alumnoDTO) {
        Alumno alumno = new Alumno();
        BeanUtils.copyProperties(alumnoDTO, alumno);
        return alumnoRepository.save(alumno);
    }

    @PutMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable Long id, @RequestBody DTOAlumnos alumnoDTO) {
        Alumno alumnoExistente = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con ID: " + id));
        BeanUtils.copyProperties(alumnoDTO, alumnoExistente);
        return alumnoRepository.save(alumnoExistente);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Long id) {
        alumnoRepository.deleteById(id);
    }
}
