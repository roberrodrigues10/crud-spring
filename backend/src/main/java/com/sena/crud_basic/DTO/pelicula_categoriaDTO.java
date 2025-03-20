package com.sena.crud_basic.DTO;

import com.sena.crud_basic.model.categorias;
import com.sena.crud_basic.model.peliculas;

public class pelicula_categoriaDTO {

    private peliculas pelicula;

    private categorias categoria;

    public pelicula_categoriaDTO(peliculas pelicula, categorias categoria) {
        this.pelicula = pelicula;
        this.categoria = categoria;
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
