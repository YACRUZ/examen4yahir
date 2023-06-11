/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.demo.controllers;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.uv.demo.dto.DTOMaterias;
import org.uv.demo.repository.MateriaRepository;
import org.uv.demo.models.Materia;

/**
 *
 * @author yacruz
 */
@RestController
@RequestMapping("/materias")
public class MateriaController {
    private final MateriaRepository materiaRepository;

    public MateriaController(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @GetMapping
    public List<Materia> obtenerTodasLasMaterias() {
        return materiaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Materia obtenerMateriaPorId(@PathVariable Long id) {
        return materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada con ID: " + id));
    }

    @PostMapping
    public Materia crearMateria(@RequestBody DTOMaterias materiaDTO) {
        Materia materia = new Materia();
        BeanUtils.copyProperties(materiaDTO, materia);
        return materiaRepository.save(materia);
    }

    @PutMapping("/{id}")
    public Materia actualizarMateria(@PathVariable Long id, @RequestBody DTOMaterias materiaDTO) {
        Materia materiaExistente = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada con ID: " + id));
        BeanUtils.copyProperties(materiaDTO, materiaExistente);
        return materiaRepository.save(materiaExistente);
    }

    @DeleteMapping("/{id}")
    public void eliminarMateria(@PathVariable Long id) {
        materiaRepository.deleteById(id);
    }
}
