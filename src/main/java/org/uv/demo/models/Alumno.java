/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.demo.models;

import javax.persistence.*;

/**
 *
 * @author yacruz
 */
@Entity
@Table(name = "Alumnos")  
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claveAlumnos;

    private String direccion;
    private String nombre;
    private String telefono;

    public Long getClaveAlumnos() {
        return claveAlumnos;
    }

    public void setClaveAlumnos(Long claveAlumnos) {
        this.claveAlumnos = claveAlumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
