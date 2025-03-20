package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.reseñasDTO;
import com.sena.crud_basic.model.reseñas;
import com.sena.crud_basic.repository.Ireseñas;
import java.util.List;
import java.util.stream.Collectors;


import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class reseñasService {

    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Ireseñas data;

    // register and update
    public void save(reseñasDTO reseñasDTO) {
        reseñas reseñasRegister = converToModel(reseñasDTO);
        data.save(reseñasRegister);
    }

    public reseñasDTO convertToDTO(reseñas reseñas) {
        reseñasDTO reseñasDTO = new reseñasDTO(
            reseñas.getUsuario(),
            reseñas.getPelicula(),
            reseñas.getPuntuacion(),
            reseñas.getComentario());
        return reseñasDTO;
    }

    public reseñas converToModel(reseñasDTO reseñasDTO) {
        reseñas reseñas = new reseñas(
                0,
                reseñasDTO.getUsuario(),
                reseñasDTO.getPelicula(),
                reseñasDTO.getPuntuacion(),
                reseñasDTO.getComentario());
        return reseñas;
    }
    public List<reseñasDTO> findAll() {
        List<reseñas> reseñass = data.findAll();
        return reseñass.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public Optional<reseñasDTO> findById(int id) {
        Optional<reseñas> reseñasOptional = data.findById(id);
        return reseñasOptional.map(this::convertToDTO);
    }

    // Método para eliminar un usuario por ID
    public boolean delete(int id) {
        Optional<reseñas> existingreseñas = data.findById(id);
        if (existingreseñas.isPresent()) {
            data.deleteById(id);
            return true;
        }
        return false;
    }
}
