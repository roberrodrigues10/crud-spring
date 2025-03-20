package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.peliculasDTO;
import com.sena.crud_basic.model.peliculas;
import com.sena.crud_basic.repository.Ipeliculas;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


@Service
public class peliculasService {

    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Ipeliculas data;

    // register and update
    public void save(peliculasDTO peliculasDTO) {
        peliculas peliculaRegister = converToModel(peliculasDTO);
        data.save(peliculaRegister);
    }

    public peliculasDTO convertToDTO(peliculas peliculas) {
        peliculasDTO pelis = new peliculasDTO(
            peliculas.getTitulo(),
            peliculas.getDuracion());
        return pelis;
    }

    public peliculas converToModel(peliculasDTO peliculasDTO) {
        peliculas pelis = new peliculas(
                0,
                peliculasDTO.getTitulo(),
                peliculasDTO.getDuracion(), null);
        return pelis;
    }
    public List<peliculasDTO> findAll() {
        List<peliculas> pelicula = data.findAll();
        return pelicula.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public Optional<peliculasDTO> findById(int id) {
        Optional<peliculas> peliculaId = data.findById(id);
        return peliculaId.map(this::convertToDTO);
    }

    // Método para eliminar un usuario por ID
    public boolean delete(int id) {
        Optional<peliculas> existePelicula = data.findById(id);
        if (existePelicula.isPresent()) {
            data.deleteById(id);
            return true;
        }
        return false;
    }
}
