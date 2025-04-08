package com.sena.crud_basic.DTO;

public class series_categoriaDTO {

    private int serieId;
    private int categoriaId;

    // Constructor vacío (requerido para deserialización JSON)
    public series_categoriaDTO() {
    }

    // Constructor con ambos IDs
    public series_categoriaDTO(int serieId, int categoriaId) {
        this.serieId = serieId;
        this.categoriaId = categoriaId;
    }

    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }
}
