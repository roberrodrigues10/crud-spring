package com.sena.crud_basic.controller;

import com.sena.crud_basic.DTO.reseñasDTO;
import com.sena.crud_basic.service.reseñasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;



@RestController
@RequestMapping("/api/v1/reseñas")
public class reseñasController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private reseñasService reseñasService;

    @PostMapping("")
    public ResponseEntity<Object> registerUser(@RequestBody reseñasDTO reseñas) {
        reseñasService.save(reseñas);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<reseñasDTO>> getAllUsers() {
        return ResponseEntity.ok(reseñasService.findAll());
    } 

    // 🔹 Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<reseñasDTO> getUserById(@PathVariable int id) {
        Optional<reseñasDTO> comentariosDTO = reseñasService.findById(id);
        return comentariosDTO.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        boolean deleted = reseñasService.delete(id);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
