package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.series_categoriaDTO;
import com.sena.crud_basic.model.serie_categoria;
import com.sena.crud_basic.repository.Iseries_categori;
import java.util.List;
import java.util.stream.Collectors;


import java.util.Optional;

@Service
public class series_categoriaService {

    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Iseries_categori data;

    // register and update
    public void save(series_categoriaDTO series_categoriaDTO) {
        serie_categoria seriesRegister = converToModel(series_categoriaDTO);
        data.save(seriesRegister);
    }

    public series_categoriaDTO convertToDTO(serie_categoria serie_categoria) {
        series_categoriaDTO series_categoriaDTO = new series_categoriaDTO(
            serie_categoria.getPelicula(),
            serie_categoria.getCategoria());
        return series_categoriaDTO;
    }

    public serie_categoria converToModel(series_categoriaDTO series_categoriaDTO) {
        serie_categoria serial = new serie_categoria(
                0,
                series_categoriaDTO.getSeries(),
                series_categoriaDTO.getCategoria());
        return serial;
    }
    public List<series_categoriaDTO> findAll() {
        List<serie_categoria> serie = data.findAll();
        return serie.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public Optional<series_categoriaDTO> findById(int id) {
        Optional<serie_categoria> serieId = data.findById(id);
        return serieId.map(this::convertToDTO);
    }

    // Método para eliminar un usuario por ID
    
    public boolean delete(int id) {
        Optional<serie_categoria> existeSerie = data.findById(id);
        if (existeSerie.isPresent()) {
            data.deleteById(id);
            return true;
        }
        return false;
    }
}
