/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.demo.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import org.uv.demo.dto.DTOGrupos;
import org.uv.demo.repository.*;
import org.uv.demo.models.*;


/**
 *
 * @author yacruz
 */
@RestController
@RequestMapping("/grupos")
public class GrupoController {

    private final GrupoRepository grupoRepository;
    private final MateriaRepository materiaRepository;
    private final AlumnoRepository alumnoRepository;

    public GrupoController(GrupoRepository grupoRepository, MateriaRepository materiaRepository, AlumnoRepository alumnoRepository) {
        this.grupoRepository = grupoRepository;
        this.materiaRepository = materiaRepository;
        this.alumnoRepository = alumnoRepository;
    }

    @PostMapping
    public Grupo crearGrupo(@RequestBody DTOGrupos grupoDTO) {
        Grupo grupo = new Grupo();
        grupo.setNombreGrupo(grupoDTO.getNombreGrupo());

        // Obtener las materias y alumnos por sus claves
        List<Materia> materias = grupoDTO.getClavesMateria().stream()
                .map(claveMateria -> materiaRepository.findById(claveMateria)
                        .orElseThrow(() -> new RuntimeException("Materia no encontrada con ID: " + claveMateria)))
                .collect(Collectors.toList());

        List<Alumno> alumnos = grupoDTO.getClavesAlumno().stream()
                .map(claveAlumno -> alumnoRepository.findById(claveAlumno)
                        .orElseThrow(() -> new RuntimeException("Alumno no encontrado con ID: " + claveAlumno)))
                .collect(Collectors.toList());

        // Asignar las materias y alumnos al grupo
        grupo.setMaterias(materias);
        grupo.setAlumnos(alumnos);

        return grupoRepository.save(grupo);
    }

    @GetMapping
    public List<Grupo> obtenerTodosLosGrupos() {
        return grupoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Grupo obtenerGrupoPorId(@PathVariable Long id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado con ID: " + id));
    }

    @DeleteMapping("/{id}")
    public void eliminarGrupo(@PathVariable Long id) {
        grupoRepository.deleteById(id);
    }
}