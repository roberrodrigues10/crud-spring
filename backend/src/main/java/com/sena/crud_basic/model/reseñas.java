package com.sena.crud_basic.model;

import jakarta.persistence.*;

@Entity(name = "reseñas")
public class reseñas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relación con la entidad usuarios (muchas reseñas pueden pertenecer a un usuario)
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private usuarios usuario;

    // Relación con la entidad peliculas
    @ManyToOne
    @JoinColumn(name = "pelicula_id", nullable = false)
    private peliculas pelicula;

    @Column(name = "puntuacion")
    private byte puntuacion;

    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;

    // Constructores
    public reseñas() {}

    public reseñas(usuarios usuario, peliculas pelicula, byte puntuacion, String comentario) {
        this.usuario = usuario;
        this.pelicula = pelicula;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    // Getters y setters
    public int getId() {
        return id;
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
