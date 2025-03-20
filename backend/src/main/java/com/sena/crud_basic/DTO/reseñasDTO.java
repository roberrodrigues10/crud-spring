package com.sena.crud_basic.DTO;

import com.sena.crud_basic.model.peliculas;
import com.sena.crud_basic.model.usuarios;

public class reseñasDTO {

    private usuarios usuario;

    private peliculas pelicula;

    private byte puntuacion;

    private String comentario;

    public reseñasDTO(usuarios usuario, peliculas pelicula, byte puntuacion, String comentario) {
        this.usuario = usuario;
        this.pelicula = pelicula;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    public usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(usuarios usuario) {
        this.usuario = usuario;
    }

    public peliculas getPelicula() {
        return pelicula;
    }

    public void setPelicula(peliculas pelicula) {
        this.pelicula = pelicula;
    }

    public byte getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(byte puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    

}
