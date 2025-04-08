let peliculasGlobal = [];

document.addEventListener('DOMContentLoaded', () => {
  getPeliculas();
});
function registerPelicula() {
    return new Promise(async (resolve) => {
      let headersList = {
        "Accept": "*/*",
        "User-Agent": "web",
        "Content-Type": "application/json"
      };
  
      let bodyContent = JSON.stringify({
        "id": 0,
        "titulo": document.getElementById("titulo").value,
        "duracion": document.getElementById("duracion").value,
        "año": document.getElementById("año").value
      });
  
      let response = await fetch("http://localhost:8080/api/v1/peliculas", {
        method: "POST",
        body: bodyContent,
        headers: headersList
      });
  
      let data = await response.text();
      console.log(data);
      getPeliculas();
    });
  }

function getPeliculas() {
  fetch("http://localhost:8080/api/v1/peliculas", {
    method: 'GET'
  })
    .then(res => res.json())
    .then(data => {
      peliculasGlobal = data;
      renderPeliculas(data);
    })
    .catch(error => {
      console.error("Error al obtener películas:", error);
    });
}

function getPeliculaPorId(id) {
  fetch(`http://localhost:8080/api/v1/peliculas/${id}`, {
    method: 'GET'
  })
    .then(res => {
      if (!res.ok) throw new Error("Película no encontrada");
      return res.json();
    })
    .then(peli => {
      renderPeliculas([peli]);
    })
    .catch(error => {
      console.error("Error al buscar por ID:", error);
      document.getElementById('peliculas').innerHTML = '<p style="color:red;">Película no encontrada</p>';
    });
}

function findById() {
  const id = document.getElementById('searchId').value.trim();
  if (id === '') {
    getPeliculas();
  } else {
    getPeliculaPorId(id);
  }
}

function filterList() {
  const filtro = document.getElementById("filter").value.toLowerCase();
  const filtradas = peliculasGlobal.filter(peli =>
    peli.titulo.toLowerCase().includes(filtro)
  );
  renderPeliculas(filtradas);
}

function renderPeliculas(lista) {
  const contenedor = document.getElementById('peliculas');
  contenedor.innerHTML = `
    <div class="col-12 row">
      <div class="col-4"><span class="tituloGet">Título</span></div>
      <div class="col-4"><span class="tituloGet">Duración</span></div>
      <div class="col-4"><span class="tituloGet">Año</span></div>
    </div>
  `;

  lista.forEach(peli => {
    const html = `
      <div class="col-12 row">
        <div class="col-4"><span class="tituloGet">${peli.titulo}</span></div>
        <div class="col-4"><span class="tituloGet">${peli.duracion}</span></div>
        <div class="col-4"><span class="tituloGet">${peli.año}</span></div>
      </div>
    `;
    contenedor.innerHTML += html;
  });
}
