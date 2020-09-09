/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.medicalsystem.vo;

import java.io.Serializable;

/**
 *
 * @author smarv
 */
public class MedicosVO implements Serializable {

    /**
     * Campo serialVersionUID de tipo long.
     */
    private static final long serialVersionUID = 1L;
    private int idMedico;
    private String nombre;
    private String patenro;
    private String materno;
    private int idEspecialidad;
    private int idTurno;
    private String direccion;
    private String colonia;
    private String delegacion;
    private String estado;
    private String cp;
    private String telefono;
    private String cedulaProfecional;
    private int idConsultorio;

    /**
     * @return the idMedico
     */
    public int getIdMedico() {
        return idMedico;
    }

    /**
     * @param idMedico the idMedico to set
     */
    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the patenro
     */
    public String getPatenro() {
        return patenro;
    }

    /**
     * @param patenro the patenro to set
     */
    public void setPatenro(String patenro) {
        this.patenro = patenro;
    }

    /**
     * @return the materno
     */
    public String getMaterno() {
        return materno;
    }

    /**
     * @param materno the materno to set
     */
    public void setMaterno(String materno) {
        this.materno = materno;
    }

    /**
     * @return the idEspecialidad
     */
    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    /**
     * @param idEspecialidad the idEspecialidad to set
     */
    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    /**
     * @return the idTurno
     */
    public int getIdTurno() {
        return idTurno;
    }

    /**
     * @param idTurno the idTurno to set
     */
    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the delegacion
     */
    public String getDelegacion() {
        return delegacion;
    }

    /**
     * @param delegacion the delegacion to set
     */
    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cp
     */
    public String getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the cedulaProfecional
     */
    public String getCedulaProfecional() {
        return cedulaProfecional;
    }

    /**
     * @param cedulaProfecional the cedulaProfecional to set
     */
    public void setCedulaProfecional(String cedulaProfecional) {
        this.cedulaProfecional = cedulaProfecional;
    }

    /**
     * @return the idConsultorio
     */
    public int getIdConsultorio() {
        return idConsultorio;
    }

    /**
     * @param idConsultorio the idConsultorio to set
     */
    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    
    
}
