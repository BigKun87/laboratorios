
  document.addEventListener("DOMContentLoaded", function() {
    // Seleccionar el elemento del select y la lista UL
    const perfilSelect = document.getElementById("perfil");
    const iconPerfil = document.querySelector(".iconPerfil");

    // Objetos que contienen las imágenes por perfil
    const perfilesImagenes = {
      "0": [
        { src: "assets/images/icons-perfiles/orden.svg", alt: "Orden" },
        { src: "assets/images/icons-perfiles/catalogo.svg", alt: "Catálogo" },
        { src: "assets/images/icons-perfiles/dashboard.svg", alt: "Dashboard" },
        { src: "assets/images/icons-perfiles/recoleccion.svg", alt: "Recolección" },
        { src: "assets/images/icons-perfiles/insumos.svg", alt: "Insumos" },
        { src: "assets/images/icons-perfiles/usuarios.svg", alt: "Usuarios" },
      ],
      "1": [
        { src: "assets/images/icons-perfiles/recoleccion.svg", alt: "Recolección" },
        { src: "assets/images/icons-perfiles/insumos.svg", alt: "Insumos" },
        { src: "assets/images/icons-perfiles/usuarios.svg", alt: "Usuarios" },
        { src: "assets/images/icons-perfiles/avisos.svg", alt: "Avisos" },
        { src: "assets/images/icons-perfiles/catalogo.svg", alt: "Catálogo" },
        { src: "assets/images/icons-perfiles/orden.svg", alt: "Orden" },
      ],
      "2": [
        { src: "assets/images/icons-perfiles/avisos.svg", alt: "Avisos" },
        { src: "assets/images/icons-perfiles/catalogo.svg", alt: "Catálogo" },
        { src: "assets/images/icons-perfiles/orden.svg", alt: "Orden" },
      ],
      "3": [
        { src: "assets/images/icons-perfiles/dashboard.svg", alt: "Dashboard" },
        { src: "assets/images/icons-perfiles/usuarios.svg", alt: "Usuarios" },
        { src: "assets/images/icons-perfiles/insumos.svg", alt: "Insumos" },
      ]
    };

    // Función para actualizar las imágenes según el perfil seleccionado
    function actualizarIconos(perfil) {
      // Limpiar la lista actual
      iconPerfil.innerHTML = "";

      // Agregar nuevas imágenes según el perfil
      perfilesImagenes[perfil].forEach(imagen => {
        const li = document.createElement("li");
        const img = document.createElement("img");
        img.src = imagen.src;
        img.alt = imagen.alt;
        li.appendChild(img);
        iconPerfil.appendChild(li);
      });
    }

    // Agregar evento al select
    perfilSelect.addEventListener("change", function() {
      const perfilSeleccionado = perfilSelect.value || "0"; // Default al perfil "0"
      actualizarIconos(perfilSeleccionado);
    });

    // Inicializar con el perfil por defecto
    actualizarIconos("0");
  });

