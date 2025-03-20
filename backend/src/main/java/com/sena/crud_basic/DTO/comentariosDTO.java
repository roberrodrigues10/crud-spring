package com.sena.crud_basic.DTO;


public class comentariosDTO {

    private int usuario_id;

    private String contenido;


    public comentariosDTO(int usuario_id, String contenido) {
        this.usuario_id = usuario_id;
        this.contenido = contenido;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
