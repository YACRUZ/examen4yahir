/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.demo.dto;

import java.util.List;

/**
 *
 * @author yacruz
 */
public class DTOGrupos {
    private List<Long> clavesMateria;
    private List<Long> clavesAlumno;
    private String nombreGrupo;

    public List<Long> getClavesMateria() {
        return clavesMateria;
    }

    public void setClavesMateria(List<Long> clavesMateria) {
        this.clavesMateria = clavesMateria;
    }

    public List<Long> getClavesAlumno() {
        return clavesAlumno;
    }

    public void setClavesAlumno(List<Long> clavesAlumno) {
        this.clavesAlumno = clavesAlumno;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    
    
}
