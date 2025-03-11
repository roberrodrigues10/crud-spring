package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.userDTO;
import com.sena.crud_basic.model.usuarios;
import com.sena.crud_basic.repository.Iuser;
import java.util.List;
import java.util.stream.Collectors;


import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class userService {

    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Iuser data;

    // register and update
    public void save(userDTO userDTO) {
        usuarios userRegister = converToModel(userDTO);
        data.save(userRegister);
    }

    public userDTO convertToDTO(usuarios user) {
        userDTO userdto = new userDTO(
            user.get_nombre(),
            user.getEmail(),
            user.get_contrasena());
        return userdto;
    }

    public usuarios converToModel(userDTO userDTO) {
        usuarios user = new usuarios(
                0,
                userDTO.getNombre(),
                userDTO.getEmail(),
                userDTO.getContrasena(),
                LocalDateTime.now());
        return user;
    }
    public List<userDTO> findAll() {
        List<usuarios> users = data.findAll();
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public Optional<userDTO> findById(int id) {
        Optional<usuarios> userOptional = data.findById(id);
        return userOptional.map(this::convertToDTO);
    }

    // Método para eliminar un usuario por ID
    public boolean delete(int id) {
        Optional<usuarios> existingUser = data.findById(id);
        if (existingUser.isPresent()) {
            data.deleteById(id);
            return true;
        }
        return false;
    }
}
