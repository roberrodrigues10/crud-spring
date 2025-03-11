package com.sena.crud_basic.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity (name="comentarios")

public class comentarios {
    /*
     * atributos o columnas de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="usuario_id",length = 50,nullable = false)
    private int usuario_id;

    @Column(name="contenido",length = 150,nullable = false)
    private String contenido;

    @Column(name="fecha",length = 150,nullable = false)
    private LocalDateTime fecha;

    //constructor
    public comentarios (int usuario_id, String contenido, LocalDateTime fecha){
        this.usuario_id = usuario_id;
        this.contenido = contenido;
        this.fecha = fecha;
     }

     //get del ID  
     public int getUsuario_id() {
        return usuario_id;
     }

     //set del ID 
     public void setUsuario_id(int usuario_id){
        this.usuario_id=usuario_id;
     }

    //get del firstName  
    public String getContenido() {
      return contenido;
     }
    
     //set del firstName 
    public void setContenido(String contenido){
         this.contenido=contenido;
     }

      //get del phone  
    public LocalDateTime getFecha() {
        return fecha;
      }
      
     //set del phone 
    public void setFecha(LocalDateTime fecha){
       this.fecha=fecha;
    }


}