let seriesGlobal = [];

document.addEventListener('DOMContentLoaded', () => {
  getSeries();
});

function registrarSerie() {
  return new Promise(async (resolve) => {
    let headersList = {
      "Accept": "*/*",
      "User-Agent": "web",
      "Content-Type": "application/json"
    };

    let bodyContent = JSON.stringify({
      "id": 0,
      "titulo": document.getElementById("titulo").value,
      "temporadas": document.getElementById("temporadas").value
    });

    let response = await fetch("http://localhost:8080/api/v1/series", {
      method: "POST",
      body: bodyContent,
      headers: headersList
    });

    let data = await response.text();
    console.log(data);
    getSeries();
  });
}

function getSeries() {
  fetch('http://localhost:8080/api/v1/series', {
    method: 'GET'
  })
  .then(response => response.json())
  .then(data => {
    seriesGlobal = data;
    renderSeries(data);
  })
  .catch(error => console.error('Error al obtener las series:', error));
}

function getSeriePorId(id) {
  fetch(`http://localhost:8080/api/v1/series/${id}`, {
    method: 'GET'
  })
  .then(response => {
    if (!response.ok) throw new Error("Serie no encontrada");
    return response.json();
  })
  .then(serie => {
    renderSeries([serie]);
  })
  .catch(error => {
    console.error('Error al buscar la serie por ID:', error);
    document.getElementById('series').innerHTML = '<p style="color:red;">Serie no encontrada</p>';
  });
}

function findById() {
  const id = document.getElementById('searchId').value.trim();
  if (id === '') {
    getSeries();
  } else {
    getSeriePorId(id);
  }
}

function filterList() {
  const filtro = document.getElementById("filter").value.toLowerCase();
  const filtradas = seriesGlobal.filter(serie =>
    serie.titulo.toLowerCase().includes(filtro)
  );
  renderSeries(filtradas);
}

function renderSeries(lista) {
  const contenedor = document.getElementById('series');
  contenedor.innerHTML = `
    <div class="col-12 row">
      <div class="col-6"><span class="tituloGet">Título</span></div>
      <div class="col-6"><span class="tituloGet">Temporadas</span></div>
    </div>
  `;

  lista.forEach(serie => {
    const html = `
      <div class="col-12 row">
        <div class="col-6"><span class="tituloGet">${serie.titulo}</span></div>
        <div class="col-6"><span class="tituloGet">${serie.temporadas}</span></div>
      </div>
    `;
    contenedor.innerHTML += html;
  });
}
