/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author atzin
 */
public class personal {

    public int idPersonal;
    private String apePaterno;
    private String apeMaterno;
    private String nombre;
    private String direccion;
    private String fechaIngreso;

    public personal(int idPersonal, String apePaterno, String apeMaterno, String nombre, String direccion, String fechaIngreso) {
        this.idPersonal = idPersonal;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
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

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

}
