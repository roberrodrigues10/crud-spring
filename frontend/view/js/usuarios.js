let usuariosGlobal = []; // Lista global de usuarios para filtros

document.addEventListener('DOMContentLoaded', () => {
  getUsuarios(); // Cargar todos al iniciar
});

function registerExplorer() {
  return new Promise(async (resolve) => {
    let headersList = {
      "Accept": "*/*",
      "User-Agent": "web",
      "Content-Type": "application/json"
    };

    let bodyContent = JSON.stringify({
      "id": 0,
      "nombre": document.getElementById("name").value,
      "email": document.getElementById("email").value,
      "contrasena": document.getElementById("password").value
    });

    let response = await fetch("http://localhost:8080/api/v1/user", {
      method: "POST",
      body: bodyContent,
      headers: headersList
    });

    let data = await response.text();
    console.log(data);
    getUsuarios(); 
  });
}

function getUsuarios() {
  fetch('http://localhost:8080/api/v1/user', {
    method: 'GET'
  })
  .then(response => response.json())
  .then(data => {
    usuariosGlobal = data; // Guardamos la lista para filtrar luego
    renderUsuarios(data);
  })
  .catch(error => console.error('Error al obtener los usuarios:', error));
}

function getUsuarioPorId(idUsuario) {
  fetch(`http://localhost:8080/api/v1/user/${idUsuario}`, {
    method: 'GET'
  })
  .then(response => {
    if (!response.ok) throw new Error("No encontrado");
    return response.json();
  })
  .then(usuario => {
    renderUsuarios([usuario]); // Mostrar como array para usar misma función
  })
  .catch(error => {
    console.error('Error al obtener el usuario:', error);
    document.getElementById('usuarios').innerHTML = '<p style="color:red;">Usuario no encontrado</p>';
  });
}

function findById() {
  const id = document.getElementById('searchId').value.trim();
  if (id === '') {
    getUsuarios(); // Mostrar todos si está vacío
  } else {
    getUsuarioPorId(id); // Buscar por ID
  }
}

function filterList() {
  const filtro = document.getElementById("filter").value.toLowerCase();

  const filtrados = usuariosGlobal.filter(usuario =>
    usuario.nombre.toLowerCase().includes(filtro) ||
    usuario.email.toLowerCase().includes(filtro)
  );

  renderUsuarios(filtrados);
}

function renderUsuarios(listaUsuarios) {
  const contenedor = document.getElementById('usuarios');
  contenedor.innerHTML = `
    <div class="col-12 row">
      <div class="col-6"><span class="tituloGet">Usuario</span></div>
      <div class="col-6"><span class="tituloGet">Email</span></div>
    </div>
  `;

  listaUsuarios.forEach(usuario => {
    const usuarioHTML = `
      <div class="col-12 row">
        <div class="col-6"><span class="tituloGet">${usuario.nombre}</span></div>
        <div class="col-6"><span class="tituloGet">${usuario.email}</span></div>
      </div>
    `;
    contenedor.innerHTML += usuarioHTML;
  });
}
