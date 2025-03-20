package com.sena.crud_basic.controller;

import com.sena.crud_basic.DTO.comentariosDTO;
import com.sena.crud_basic.service.comentariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;



@RestController
@RequestMapping("/api/v1/comentarios")
public class comentariosController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private comentariosService comentariosService;

    @PostMapping("")
    public ResponseEntity<Object> registerUser(@RequestBody comentariosDTO comentarios) {
        comentariosService.save(comentarios);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<comentariosDTO>> getAllUsers() {
        return ResponseEntity.ok(comentariosService.findAll());
    } 

    // 🔹 Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<comentariosDTO> getUserById(@PathVariable int id) {
        Optional<comentariosDTO> comentariosDTO = comentariosService.findById(id);
        return comentariosDTO.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    } 
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        boolean deleted = comentariosService.delete(id);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
