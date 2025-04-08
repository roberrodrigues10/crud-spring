package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import com.sena.crud_basic.DTO.histo_visualiDTO;
import com.sena.crud_basic.model.historial_visualizacion;
import com.sena.crud_basic.repository.Ihisto_visuali;
import java.util.List;
import java.util.stream.Collectors;


import java.util.Optional;

@Service
public class histo_visualiService {

    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Ihisto_visuali data;

    // register and update
    public void save(histo_visualiDTO histo_visualiDTO) {
        historial_visualizacion historial_visualizacionRegister = converToModel(histo_visualiDTO);
        data.save(historial_visualizacionRegister);
    }

    public histo_visualiDTO convertToDTO(historial_visualizacion historial_visualizacion) {
        histo_visualiDTO histo_visualiDTO = new histo_visualiDTO(
            historial_visualizacion.getUsuario(),
            historial_visualizacion.getContenidoId(),
            historial_visualizacion.getTipoContenido());
        return histo_visualiDTO;
    }

    public historial_visualizacion converToModel(histo_visualiDTO   histo_visualiDTO) {
        historial_visualizacion historial_visualizacion = new historial_visualizacion(
                0,
                histo_visualiDTO.getUsuario(),
                histo_visualiDTO.getContenidoId(),
                histo_visualiDTO.getTipoContenido(),
                LocalDateTime.now());
        return historial_visualizacion;
    }
    public List<histo_visualiDTO> findAll() {
        List<historial_visualizacion> historial_visualizacions = data.findAll();
        return historial_visualizacions.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
    public Optional<histo_visualiDTO> findById(int id) {
        Optional<historial_visualizacion> historial_visualizacionOptional = data.findById(id);
        return historial_visualizacionOptional.map(this::convertToDTO);
    }

    // Método para eliminar un usuario por ID
    public boolean delete(int id) {
        Optional<historial_visualizacion> existinghistorial_visualizacion = data.findById(id);
        if (existinghistorial_visualizacion.isPresent()) {
            data.deleteById(id);
            return true;
        }
        return false;
    }
}
