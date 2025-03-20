package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.comentariosDTO;
import com.sena.crud_basic.model.comentarios;
import com.sena.crud_basic.repository.Icomentarios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


@Service
public class comentariosService {

    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Icomentarios data;

    // register and update
    public void save(comentariosDTO comentariosDTO) {
        comentarios comentariosRegister = converToModel(comentariosDTO);
        data.save(comentariosRegister);
    }

    public comentariosDTO convertToDTO(comentarios comentarios) {
        comentariosDTO comentariosDTO = new comentariosDTO(
            comentarios.getUsuario_id(),
            comentarios.getContenido());
        return comentariosDTO;
    }

    public comentarios converToModel(comentariosDTO comentariosDTO) {
        comentarios comentarios = new comentarios(
                0,
                comentariosDTO.getContenido(),
                LocalDateTime.now());
        return comentarios;
    }
    public List<comentariosDTO> findAll() {
        List<comentarios> categoria = data.findAll();
        return categoria.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public Optional<comentariosDTO> findById(int id) {
        Optional<comentarios> categoriaId = data.findById(id);
        return categoriaId.map(this::convertToDTO);
    }

    // Método para eliminar un usuario por ID
    public boolean delete(int id) {
        Optional<comentarios> existeCategoria = data.findById(id);
        if (existeCategoria.isPresent()) {
            data.deleteById(id);
            return true;
        }
        return false;
    }
}
