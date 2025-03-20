package com.sena.crud_basic.controller;

import com.sena.crud_basic.DTO.seriesDTO;
import com.sena.crud_basic.service.seriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;



@RestController
@RequestMapping("/api/v1/series")
public class seriesController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private seriesService seriesService;

    @PostMapping("")
    public ResponseEntity<Object> registerUser(@RequestBody seriesDTO series) {
        seriesService.save(series);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<seriesDTO>> getAllUsers() {
        return ResponseEntity.ok(seriesService.findAll());
    } 

    // 🔹 Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<seriesDTO> getUserById(@PathVariable int id) {
        Optional<seriesDTO> seriesDTO = seriesService.findById(id);
        return seriesDTO.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    } 
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        boolean deleted = seriesService.delete(id);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
