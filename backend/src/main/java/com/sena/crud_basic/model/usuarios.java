package com.sena.crud_basic.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "usuarios")

public class usuarios {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;

   @Column(name = "nombre", length = 50, nullable = false)
   private String nombre;

   @Column(name = "email", length = 150, nullable = false)
   private String email;

   @Column(name = "contrasena", length = 150, nullable = false)
   private String contrasena;

   @Column(name = "fecha_registro", nullable = false)
   private LocalDateTime fecha_registro;

   // 🔹 Constructor vacío (Obligatorio para JPA)
   public usuarios() {
   }

   // 🔹 Constructor con parámetros
   public usuarios(int id, String nombre, String email, String contrasena, LocalDateTime fecha_registro) {
      this.id = id;
      this.nombre = nombre;
      this.email = email;
      this.contrasena = contrasena;
      this.fecha_registro = fecha_registro;
   }

   // Getters y Setters
   public int get_id() {
      return id;
   }

   public void set_id(int id) {
      this.id = id;
   }

   public String getNombre() {
      return nombre;
   }

   public void set_nombre(String nombre) {  // Corregido el nombre del setter
      this.nombre = nombre;
   }

   public String get_contrasena() {
      return contrasena;
   }

   public void set_contrasena(String contrasena) {
      this.contrasena = contrasena;
   }

   public LocalDateTime get_fecha_registro() {
      return fecha_registro;
   }

   public void set_fecha_registro(LocalDateTime fecha_registro) {
      this.fecha_registro = fecha_registro;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
