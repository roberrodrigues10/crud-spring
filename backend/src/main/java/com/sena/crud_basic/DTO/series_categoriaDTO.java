package com.sena.crud_basic.DTO;

import com.sena.crud_basic.model.categorias;
import com.sena.crud_basic.model.series;

public class series_categoriaDTO {

    private series series;

    private categorias categoria;

    public series_categoriaDTO(com.sena.crud_basic.model.series series, categorias categoria) {
        this.series = series;
        this.categoria = categoria;
    }

    public series getSeries() {
        return series;
    }

    public void setSeries(series series) {
        this.series = series;
    }

    public categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(categorias categoria) {
        this.categoria = categoria;
    }
    
    
}
