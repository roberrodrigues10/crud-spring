package com.sena.crud_basic.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "historial_visualizacion")
public class historial_visualizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relación con la entidad usuarios
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private usuarios usuario;

    @Column(name = "contenido_id", nullable = false)
    private int contenidoId;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_contenido", nullable = false)
    private tipoContenido tipoContenido;

    @Column(name = "fecha", columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
