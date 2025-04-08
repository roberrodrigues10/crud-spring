let comentariosGlobal = [];

document.addEventListener('DOMContentLoaded', () => {
  getComentarios();
});

function registrarComentario() {
  return new Promise(async (resolve) => {
    let headersList = {
      "Accept": "*/*",
      "User-Agent": "web",
      "Content-Type": "application/json"
    };

    let bodyContent = JSON.stringify({
      "usuario_id": parseInt(document.getElementById("usuario_id").value),
      "contenido": document.getElementById("contenido").value
    });

    let response = await fetch("http://localhost:8080/api/v1/comentarios", {
      method: "POST",
      body: bodyContent,
      headers: headersList
    });

    let data = await response.text();
    console.log(data);
    getComentarios();
    resolve(); // opcional
  });
}

function getComentarios() {
  fetch('http://localhost:8080/api/v1/comentarios', {
    method: 'GET'
  })
    .then(response => response.json())
    .then(data => {
      comentariosGlobal = data;
      renderComentarios(data);
    })
    .catch(error => console.error('Error al obtener los comentarios:', error));
}

function getComentarioPorId(id) {
  fetch(`http://localhost:8080/api/v1/comentarios/${id}`, {
    method: 'GET'
  })
    .then(response => {
      if (!response.ok) throw new Error("Comentario no encontrado");
      return response.json();
    })
    .then(comentario => {
      renderComentarios([comentario]);
    })
    .catch(error => {
      console.error('Error al buscar el comentario por ID:', error);
      document.getElementById('comentarios').innerHTML = '<p style="color:red;">Comentario no encontrado</p>';
    });
}

function findComentarioById() {
  const id = document.getElementById('searchId').value.trim();
  if (id === '') {
    getComentarios();
  } else {
    getComentarioPorId(id);
  }
}

function filterComentarios() {
  const filtro = document.getElementById("filter").value.toLowerCase();
  const filtrados = comentariosGlobal.filter(com =>
    com.contenido.toLowerCase().includes(filtro)
  );
  renderComentarios(filtrados);
}

function renderComentarios(lista) {
  const contenedor = document.getElementById('comentarios');
  contenedor.innerHTML = `
    <div class="col-12 row">
      <div class="col-6"><span class="tituloGet">Usuario ID</span></div>
      <div class="col-6"><span class="tituloGet">Contenido</span></div>
    </div>
  `;

  lista.forEach(comentario => {
    const html = `
      <div class="col-12 row">
        <div class="col-6"><span class="tituloGet">${comentario.usuario_id}</span></div>
        <div class="col-6"><span class="tituloGet">${comentario.contenido}</span></div>
      </div>
    `;
    contenedor.innerHTML += html;
  });
}
