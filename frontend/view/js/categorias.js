let categoriasGlobal = [];

document.addEventListener('DOMContentLoaded', () => {
  getCategorias();
});

// Registrar categoría (tal como lo pediste)
function registerCate() {
  return new Promise(async (resolve) => {
    let headersList = {
      "Accept": "*/*",
      "User-Agent": "web",
      "Content-Type": "application/json"
    };

    let bodyContent = JSON.stringify({
      "id": 0,
      "nombre": document.getElementById("nombre").value
    });

    let response = await fetch("http://localhost:8080/api/v1/categorias", {
      method: "POST",
      body: bodyContent,
      headers: headersList
    });

    let data = await response.text();
    console.log(data);
    getCategorias();
  });
}

// Obtener todas las categorías
function getCategorias() {
  fetch('http://localhost:8080/api/v1/categorias', {
    method: 'GET'
  })
    .then(response => response.json())
    .then(data => {
      categoriasGlobal = data;
      renderCategorias(data);
    })
    .catch(error => console.error('Error al obtener categorías:', error));
}

// Buscar por ID
function getCategoriaPorId(id) {
  fetch(`http://localhost:8080/api/v1/categorias/${id}`, {
    method: 'GET'
  })
    .then(response => {
      if (!response.ok) throw new Error("Categoría no encontrada");
      return response.json();
    })
    .then(categoria => {
      renderCategorias([categoria]);
    })
    .catch(error => {
      console.error('Error al buscar categoría por ID:', error);
      document.getElementById('userList').innerHTML = '<p style="color:red;">Categoría no encontrada</p>';
    });
}

function findById() {
  const id = document.getElementById('searchId').value.trim();
  if (id === '') {
    getCategorias();
  } else {
    getCategoriaPorId(id);
  }
}

// Filtrar por nombre
function filterList() {
  const filtro = document.getElementById("filter").value.toLowerCase();
  const filtradas = categoriasGlobal.filter(cat =>
    cat.nombre.toLowerCase().includes(filtro)
  );
  renderCategorias(filtradas);
}

function renderCategorias(lista) {
  const contenedor = document.getElementById('categorias');
  contenedor.innerHTML = `
    <div class="col-12 row">
      <div class="col-12"><span class="tituloGet">Nombre</span></div>
    </div>
  `;

  lista.forEach(cat => {
    const html = `
      <div class="col-12 row">
        <div class="col-12"><span class="tituloGet">${cat.nombre}</span></div>
      </div>
    `;
    contenedor.innerHTML += html;
  });
}