package com.sena.crud_basic.controller;

import com.sena.crud_basic.DTO.series_categoriaDTO;
import com.sena.crud_basic.service.series_categoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;



@RestController
@RequestMapping("/api/v1/series_categoria")
public class serie_categoriaController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private series_categoriaService series_categoriaService;

    @PostMapping("")
    public ResponseEntity<Object> registerUser(@RequestBody series_categoriaDTO seriecate) {
        series_categoriaService.save(seriecate);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<series_categoriaDTO>> getAllUsers() {
        return ResponseEntity.ok(series_categoriaService.findAll());
    } 

    // 🔹 Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<series_categoriaDTO> getUserById(@PathVariable int id) {
        Optional<series_categoriaDTO> seriesDTO = series_categoriaService.findById(id);
        return seriesDTO.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    } 
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        boolean deleted = series_categoriaService.delete(id);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
