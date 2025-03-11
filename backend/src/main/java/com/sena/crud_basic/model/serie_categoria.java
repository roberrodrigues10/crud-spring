package com.sena.crud_basic.model;

import jakarta.persistence.*;

@Entity(name = "serie_categoria")
public class serie_categoria {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Relación con la entidad pelicula
    @ManyToOne
    @JoinColumn(name = "serie_id", nullable = false)
    private series series;

    // Relación con la entidad categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private categorias categoria;

    // Constructores
    public serie_categoria() {}

    public serie_categoria(series series, categorias categoria) {
        this.series = series;
        this.categoria = categoria;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public series getPelicula() {
        return series;
    }

    public void setPelicula(series series) {
        this.series = series;
    }

    public categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(categorias categoria) {
        this.categoria = categoria;
    }
}
