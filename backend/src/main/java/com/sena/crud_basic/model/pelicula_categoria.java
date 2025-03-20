package com.sena.crud_basic.model;

import jakarta.persistence.*;

@Entity(name = "pelicula_categoria")
public class pelicula_categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relación con la entidad pelicula
    @ManyToOne
    @JoinColumn(name = "pelicula_id", nullable = false)
    private peliculas pelicula;

    // Relación con la entidad categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private categorias categoria;

    // Constructores
    public pelicula_categoria() {}

    public pelicula_categoria(int id, peliculas pelicula, categorias categoria) {
        this.id = id;
        this.pelicula = pelicula;
        this.categoria = categoria;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public peliculas getPelicula() {
        return pelicula;
    }

    public void setPelicula(peliculas pelicula) {
        this.pelicula = pelicula;
    }

    public categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(categorias categoria) {
        this.categoria = categoria;
    }
}
