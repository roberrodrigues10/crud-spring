package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.seriesDTO;
import com.sena.crud_basic.model.series;
import com.sena.crud_basic.repository.Iseries;
import java.util.List;
import java.util.stream.Collectors;


import java.util.Optional;

@Service
public class seriesService {

    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Iseries data;

    // register and update
    public void save(seriesDTO seriesDTO) {
        series seriesRegister = converToModel(seriesDTO);
        data.save(seriesRegister);
    }

    public seriesDTO convertToDTO(series series) {
        seriesDTO seriesDTO = new seriesDTO(
            series.getTitulo(),
            series.getTemporadas());
        return seriesDTO;
    }

    public series converToModel(seriesDTO seriesDTO) {
        series serial = new series(
                0,
                seriesDTO.getTitulo(),
                seriesDTO.getTemporadas());
        return serial;
    }
    public List<seriesDTO> findAll() {
        List<series> serie = data.findAll();
        return serie.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public Optional<seriesDTO> findById(int id) {
        Optional<series> serieId = data.findById(id);
        return serieId.map(this::convertToDTO);
    }

    // Método para eliminar un usuario por ID
    public boolean delete(int id) {
        Optional<series> existeSerie = data.findById(id);
        if (existeSerie.isPresent()) {
            data.deleteById(id);
            return true;
        }
        return false;
    }
}
