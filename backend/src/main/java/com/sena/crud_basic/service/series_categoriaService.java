package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.series_categoriaDTO;
import com.sena.crud_basic.model.serie_categoria;
import com.sena.crud_basic.model.series;
import com.sena.crud_basic.model.categorias;
import com.sena.crud_basic.repository.Iseries_categori;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class series_categoriaService {

    @Autowired
    private Iseries_categori data;

    // Registrar la relación
    public void save(series_categoriaDTO dto) {
        serie_categoria relacion = converToModel(dto);
        data.save(relacion);
    }

    // Convertir de entidad a DTO
    public series_categoriaDTO convertToDTO(serie_categoria entidad) {
        return new series_categoriaDTO(
                entidad.getSeries().getId(),
                entidad.getCategoria().getId()
        );
    }

    // Convertir de DTO a entidad
    public serie_categoria converToModel(series_categoriaDTO dto) {
        series serie = new series();
        serie.setId(dto.getSerieId());

        categorias categoria = new categorias();
        categoria.setId(dto.getCategoriaId());

        return new serie_categoria(0, serie, categoria);
    }

    // Listar todas las relaciones
    public List<series_categoriaDTO> findAll() {
        List<serie_categoria> lista = data.findAll();
        return lista.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Buscar una relación por ID
    public Optional<series_categoriaDTO> findById(int id) {
        Optional<serie_categoria> encontrada = data.findById(id);
        return encontrada.map(this::convertToDTO);
    }

    // Eliminar una relación por ID
    public boolean delete(int id) {
        Optional<serie_categoria> existe = data.findById(id);
        if (existe.isPresent()) {
            data.deleteById(id);
            return true;
        }
        return false;
    }
}
