package com.sena.crud_basic.controller;

import com.sena.crud_basic.DTO.histo_visualiDTO;
import com.sena.crud_basic.service.histo_visualiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;



@RestController
@RequestMapping("/api/v1/histo_visualozacion")
public class histo_visualizacionController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private histo_visualiService histo_visualiService;

    @PostMapping("")
    public ResponseEntity<Object> registerUser(@RequestBody histo_visualiDTO histovisual) {
        histo_visualiService.save(histovisual);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<histo_visualiDTO>> getAllUsers() {
        return ResponseEntity.ok(histo_visualiService.findAll());
    } 

    // 🔹 Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<histo_visualiDTO> getUserById(@PathVariable int id) {
        Optional<histo_visualiDTO> comentariosDTO = histo_visualiService.findById(id);
        return comentariosDTO.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        boolean deleted = histo_visualiService.delete(id);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
