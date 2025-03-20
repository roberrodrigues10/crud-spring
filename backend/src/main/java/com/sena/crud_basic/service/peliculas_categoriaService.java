package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.pelicula_categoriaDTO;
import com.sena.crud_basic.model.pelicula_categoria;
import com.sena.crud_basic.repository.Ipeliculas_categori;
import java.util.List;
import java.util.stream.Collectors;


import java.util.Optional;

@Service
public class peliculas_categoriaService {

    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Ipeliculas_categori data;

    // register and update
    public void save(pelicula_categoriaDTO pelicula_categoriaDTO) {
        pelicula_categoria peliculassRegister = converToModel(pelicula_categoriaDTO);
        data.save(peliculassRegister);
    }

    public pelicula_categoriaDTO convertToDTO(pelicula_categoria pelicula_categoria) {
        pelicula_categoriaDTO pelicula_categoriaDTO = new pelicula_categoriaDTO(
            pelicula_categoria.getPelicula(),
            pelicula_categoria.getCategoria());
        return pelicula_categoriaDTO;
    }

    public pelicula_categoria converToModel(pelicula_categoriaDTO pelicula_categoriaDTO) {
        pelicula_categoria serial = new pelicula_categoria(
                0,
                pelicula_categoriaDTO.getPelicula(),
                pelicula_categoriaDTO.getCategoria());
        return serial;
    }
    public List<pelicula_categoriaDTO> findAll() {
        List<pelicula_categoria> peliculas = data.findAll();
        return peliculas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public Optional<pelicula_categoriaDTO> findById(int id) {
        Optional<pelicula_categoria> peliculasId = data.findById(id);
        return peliculasId.map(this::convertToDTO);
    }

    // Método para eliminar un usuario por ID
    
    public boolean delete(int id) {
        Optional<pelicula_categoria> existepeliculas = data.findById(id);
        if (existepeliculas.isPresent()) {
            data.deleteById(id);
            return true;
        }
        return false;
    }
}
