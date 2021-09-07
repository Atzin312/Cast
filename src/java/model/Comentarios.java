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
public class Comentarios {

    private int idComentario;
    private int idNoticia;
    private int idPersonal;
    private int idUsuario;
    private String comentario;
    private int idComentarioR;
    private int idPersonaR;
    private int idUsuarioR;
    private String nombreCompleto;

    public Comentarios() {

    }

    public Comentarios(int idComentario, int idNoticia, int idPersonal, int idUsuario, String comentario, int idComentarioR, int idPersonaR, int idUsuarioR, String nombreCompleto) {
        this.idComentario = idComentario;
        this.idNoticia = idNoticia;
        this.idPersonal = idPersonal;
        this.idUsuario = idUsuario;
        this.comentario = comentario;
        this.idComentarioR = idComentarioR;
        this.idPersonaR = idPersonaR;
        this.idUsuarioR = idUsuarioR;
        this.nombreCompleto = nombreCompleto;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdComentarioR() {
        return idComentarioR;
    }

    public void setIdComentarioR(int idComentarioR) {
        this.idComentarioR = idComentarioR;
    }

    public int getIdPersonaR() {
        return idPersonaR;
    }

    public void setIdPersonaR(int idPersonaR) {
        this.idPersonaR = idPersonaR;
    }

    public int getIdUsuarioR() {
        return idUsuarioR;
    }

    public void setIdUsuarioR(int idUsuarioR) {
        this.idUsuarioR = idUsuarioR;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

}
