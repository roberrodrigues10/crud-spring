document.addEventListener('DOMContentLoaded', () => {
    renderSerieCategorias();
  });
  
  async function renderSerieCategorias() {
    try {
      const response = await fetch("http://localhost:8080/api/v1/series_categoria");
      const data = await response.json();
  
      const contenedor = document.getElementById("relaciones");
      contenedor.innerHTML = ""; // limpiar
  
      data.forEach((item, index) => {
        contenedor.innerHTML += `
          <div class="card p-3 mb-2">
            <h5>Relación #${index + 1}</h5>
            <p><strong>ID Serie:</strong> ${item.serieId}</p>
            <p><strong>ID Categoría:</strong> ${item.categoriaId}</p>
            <button onclick="eliminarRelacion(${item.id})" class="btn btn-danger btn-sm">Eliminar</button>
          </div>
        `;
      });
  
    } catch (error) {
      console.error("Error cargando relaciones:", error);
    }
  }
  
  async function registrarRelacion() {
    const serieId = document.getElementById("serie_id").value;
    const categoriaId = document.getElementById("categoria_id").value;
  
    const body = {
      serieId: parseInt(serieId),
      categoriaId: parseInt(categoriaId)
    };
  
    try {
      const response = await fetch("http://localhost:8080/api/v1/series_categoria", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
      });
  
      if (!response.ok) {
        throw new Error("Error al registrar");
      }
  
      alert("Relación registrada correctamente.");
      renderSerieCategorias(); // Recargar lista
    } catch (error) {
      console.error("Error al registrar la relación:", error);
    }
  }
  