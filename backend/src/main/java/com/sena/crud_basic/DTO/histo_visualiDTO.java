package com.sena.crud_basic.DTO;

import com.sena.crud_basic.model.tipoContenido;
import com.sena.crud_basic.model.usuarios;

public class histo_visualiDTO {

    private usuarios usuario;

    private int contenidoId;

    private tipoContenido tipoContenido;


    public histo_visualiDTO(usuarios usuario, int contenidoId, com.sena.crud_basic.model.tipoContenido tipoContenido) {
        this.usuario = usuario;
        this.contenidoId = contenidoId;
        this.tipoContenido = tipoContenido;
    }


    public usuarios getUsuario() {
        return usuario;
    }


    public void setUsuario(usuarios usuario) {
        this.usuario = usuario;
    }


    public int getContenidoId() {
        return contenidoId;
    }


    public void setContenidoId(int contenidoId) {
        this.contenidoId = contenidoId;
    }


    public tipoContenido getTipoContenido() {
        return tipoContenido;
    }


    public void setTipoContenido(tipoContenido tipoContenido) {
        this.tipoContenido = tipoContenido;
    }


    
}
