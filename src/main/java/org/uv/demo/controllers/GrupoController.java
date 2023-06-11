/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.demo.controllers;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    
    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @Autowired
    private MateriaRepository materiaRepository;

    public GrupoController(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
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

    @PostMapping
    public Grupo crearGrupo(@RequestBody DTOGrupos grupoDTO) {
        Grupo grupo = new Grupo();
        BeanUtils.copyProperties(grupoDTO, grupo, "claveMateria", "claveAlumno"); // Excluir los campos claveMateria y claveAlumno de la copia

        // Asignar manualmente los valores de claveMateria y claveAlumno
        Materia materia = materiaRepository.findById(grupoDTO.getClaveMateria())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada con ID: " + grupoDTO.getClaveMateria()));
        Alumno alumno = alumnoRepository.findById(grupoDTO.getClaveAlumno())
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con ID: " + grupoDTO.getClaveAlumno()));

        grupo.setMateria(materia);
        grupo.setAlumno(alumno);
        grupo.setNombreGrupo(grupoDTO.getNombreGrupo());

        return grupoRepository.save(grupo);
    }

    @PutMapping("/{id}")
    public Grupo actualizarGrupo(@PathVariable Long id, @RequestBody DTOGrupos grupoDTO) {
        Grupo grupoExistente = grupoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado con ID: " + id));
        BeanUtils.copyProperties(grupoDTO, grupoExistente);
        return grupoRepository.save(grupoExistente);
    }

    @DeleteMapping("/{id}")
    public void eliminarGrupo(@PathVariable Long id) {
        grupoRepository.deleteById(id);
    }
}
