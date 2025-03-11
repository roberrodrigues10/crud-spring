package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity (name="categorias")

public class categorias {
    /*
     * atributos o columnas de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nombre",length = 50,nullable = false)
    private String nombre;

    //constructor
    public categorias (String nombre ){
        this.nombre = nombre;
     }

    //get del firstName  
    public String get_nombre_categoria() {
      return nombre;
     }
    
     //set del firstName 
    public void set_nombre_categoria(String nombre_categoria){
         this.nombre = nombre_categoria;
     }
}