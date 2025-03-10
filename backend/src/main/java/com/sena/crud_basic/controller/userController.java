package com.sena.crud_basic.controller;

import com.sena.crud_basic.DTO.userDTO;
import com.sena.crud_basic.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class userController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private userService userService;

    @PostMapping("")
    public ResponseEntity<Object> registerUser(@RequestBody userDTO user) {
        userService.save(user);
        return new ResponseEntity<>("register OK", HttpStatus.OK);
    }
     @GetMapping("")
    public ResponseEntity<List<userDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    // 🔹 Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<userDTO> getUserById(@PathVariable int id) {
        Optional<userDTO> userDTO = userService.findById(id);
        return userDTO.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        boolean deleted = userService.delete(id);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
