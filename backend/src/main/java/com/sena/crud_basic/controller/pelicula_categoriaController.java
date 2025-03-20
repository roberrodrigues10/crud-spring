package com.sena.crud_basic.controller;

import com.sena.crud_basic.DTO.pelicula_categoriaDTO;
import com.sena.crud_basic.service.peliculas_categoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;



@RestController
@RequestMapping("/api/v1/pelicula_categoria")
public class pelicula_categoriaController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private peliculas_categoriaService peliculas_categoriaService;

    @PostMapping("")
    public ResponseEntity<Object> registerUser(@RequestBody pelicula_categoriaDTO peliculas) {
        peliculas_categoriaService.save(peliculas);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<pelicula_categoriaDTO>> getAllUsers() {
        return ResponseEntity.ok(peliculas_categoriaService.findAll());
    } 

    // 🔹 Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<pelicula_categoriaDTO> getUserById(@PathVariable int id) {
        Optional<pelicula_categoriaDTO> seriesDTO = peliculas_categoriaService.findById(id);
        return seriesDTO.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    } 
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        boolean deleted = peliculas_categoriaService.delete(id);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
