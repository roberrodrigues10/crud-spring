package com.sena.crud_basic.DTO;

public class seriesDTO {

    private String titulo;

    private int temporadas;

    public seriesDTO(String titulo, int temporadas) {
        this.titulo = titulo;
        this.temporadas = temporadas;
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
