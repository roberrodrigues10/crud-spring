package com.sena.crud_basic.model;

import java.time.Year;
import jakarta.persistence.*;

@Entity(name = "peliculas")
public class peliculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "año")
    private Year año;

    public peliculas() {}

    public peliculas(String titulo, int duracion, Year año) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.año = año;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Year getAño() {
        return año;
    }

    public void setAño(Year año) {
        this.año = año;
    }
}
