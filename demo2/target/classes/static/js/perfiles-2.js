document.addEventListener("DOMContentLoaded", function() {
  // Obtener el switch y los checkboxes de la tabla
  const switchInput = document.getElementById("urgentStudy");
  const checkboxes = document.querySelectorAll(".checkbox-item");

  // Función para activar/desactivar todos los checkboxes
  function toggleCheckboxes(estado) {
    checkboxes.forEach(function(checkbox) {
      checkbox.checked = estado;
    });
  }

  // Evento cuando el estado del switch cambia
  switchInput.addEventListener("change", function() {
    if (switchInput.checked) {
      toggleCheckboxes(true); // Activa todos los checkboxes
    } else {
      toggleCheckboxes(false); // Desactiva todos los checkboxes
    }
  });
});