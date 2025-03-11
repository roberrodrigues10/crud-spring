package com.sena.crud_basic.model;

import jakarta.persistence.*;

@Entity(name = "series")
public class series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;

    @Column(name = "temporadas")
    private int temporadas;

    public series() {}

    public series(String titulo, int temporadas) {
        this.titulo = titulo;
        this.temporadas = temporadas;
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

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
}
