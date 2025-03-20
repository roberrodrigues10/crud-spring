package com.sena.crud_basic.controller;

import com.sena.crud_basic.DTO.categoriasDTO;
import com.sena.crud_basic.service.categoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;



@RestController
@RequestMapping("/api/v1/categorias")
public class categoriasController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private categoriasService categoriasService;

    @PostMapping("")
    public ResponseEntity<Object> registerUser(@RequestBody categoriasDTO categorias) {
        categoriasService.save(categorias);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<categoriasDTO>> getAllUsers() {
        return ResponseEntity.ok(categoriasService.findAll());
    } 

    // 🔹 Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<categoriasDTO> getUserById(@PathVariable int id) {
        Optional<categoriasDTO> categoriasDTO = categoriasService.findById(id);
        return categoriasDTO.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    } 
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        boolean deleted = categoriasService.delete(id);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
