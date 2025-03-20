package com.sena.crud_basic.DTO;


public class categoriasDTO {

    private String nombre;

    public categoriasDTO() {}

    public categoriasDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
