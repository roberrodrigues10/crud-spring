package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.categoriasDTO;
import com.sena.crud_basic.model.categorias;
import com.sena.crud_basic.repository.Icategorias;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


@Service
public class categoriasService {

    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Icategorias data;

    // register and update
    public void save(categoriasDTO categoriasDTO) {
        categorias categoriaRegister = converToModel(categoriasDTO);
        data.save(categoriaRegister);
    }

    public categoriasDTO convertToDTO(categorias categorias) {
        categoriasDTO categoria = new categoriasDTO(
            categorias.getNombre());
        return categoria;
    }

    public categorias converToModel(categoriasDTO categoriasDTO) {
        categorias categorias = new categorias(
                0,
                categoriasDTO.getNombre());
        return categorias;
    }
    public List<categoriasDTO> findAll() {
        List<categorias> categoria = data.findAll();
        return categoria.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public Optional<categoriasDTO> findById(int id) {
        Optional<categorias> categoriaId = data.findById(id);
        return categoriaId.map(this::convertToDTO);
    }

    // Método para eliminar un usuario por ID
    public boolean delete(int id) {
        Optional<categorias> existeCategoria = data.findById(id);
        if (existeCategoria.isPresent()) {
            data.deleteById(id);
            return true;
        }
        return false;
    }
}
