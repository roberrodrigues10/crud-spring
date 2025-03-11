package com.sena.crud_basic.model;

import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity (name="peliculas")

public class peliculas {
    /*
     * atributos o columnas de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="titulo",length = 50,nullable = false)
    private String titulo;
    @Column(name="duracion")
    private int temporadas;
    @Column(name="año")
    private Year año;
    public peliculas(String titulo, int temporadas, Year año) {
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.año = año;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
    public Year getAño() {
        return año;
    }
    public void setAño(Year año) {
        this.año = año;
    }
     
}