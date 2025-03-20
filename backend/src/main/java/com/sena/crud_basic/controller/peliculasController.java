package com.sena.crud_basic.controller;

import com.sena.crud_basic.DTO.peliculasDTO;
import com.sena.crud_basic.service.peliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;



@RestController
@RequestMapping("/api/v1/peliculas")
public class peliculasController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private peliculasService peliculasService;

    @PostMapping("")
    public ResponseEntity<Object> registerUser(@RequestBody peliculasDTO peliculas) {
        peliculasService.save(peliculas);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<peliculasDTO>> getAllUsers() {
        return ResponseEntity.ok(peliculasService.findAll());
    } 

    // 🔹 Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<peliculasDTO> getUserById(@PathVariable int id) {
        Optional<peliculasDTO> peliculasDTO = peliculasService.findById(id);
        return peliculasDTO.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    } 
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        boolean deleted = peliculasService.delete(id);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
