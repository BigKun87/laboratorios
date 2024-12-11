document.addEventListener('DOMContentLoaded', () => {
  const modal = new bootstrap.Modal(document.getElementById('editDeleteModal'));
  const form = document.getElementById('editForm');
  const editSection = document.getElementById('editFormSection');
  const deleteSection = document.getElementById('deleteConfirmSection');
  let currentElement, isDeleteAction;

  const openModal = (element, isDelete = false) => {
    currentElement = element;
    isDeleteAction = isDelete;

    if (isDelete) {
      editSection.style.display = 'none';
      deleteSection.style.display = 'block';
    } else {
      document.getElementById('editFecha').value = element.cells[1].textContent;
      document.getElementById('editPaciente').value = element.cells[2].textContent;
      document.getElementById('editEstudios').value = element.cells[3].textContent;
      document.getElementById('editImporte').value = element.cells[4].textContent;
      editSection.style.display = 'block';
      deleteSection.style.display = 'none';
    }
    modal.show();
  };

  const updateRow = () => {
    currentElement.cells[1].textContent = document.getElementById('editFecha').value;
    currentElement.cells[2].textContent = document.getElementById('editPaciente').value;
    currentElement.cells[3].textContent = document.getElementById('editEstudios').value;
    currentElement.cells[4].textContent = document.getElementById('editImporte').value;
  };

  document.querySelectorAll('.edit-btn').forEach(button =>
    button.addEventListener('click', (e) => openModal(e.target.closest('tr')))
  );

  document.querySelectorAll('.delete-btn').forEach(button =>
    button.addEventListener('click', (e) => {
      const row = e.target.closest('tr'); 
      const container = e.target.closest('.d-flex'); 

      if (row) {
        openModal(row, true); 
      } else if (container) {
        openModal(container, true); 
      }
    })
  );

  document.getElementById('confirmDeleteBtn').addEventListener('click', () => {
    if (currentElement) {

      if (currentElement.classList.contains('accordion-header')) {
        const accordionId = currentElement.querySelector('.acc-btn-orden').getAttribute('data-bs-target');
        const accordionElement = document.querySelector(accordionId);
        if (accordionElement) accordionElement.closest('.accordion-item').remove();
      }

      currentElement.remove();
    }
    modal.hide();
  });

  form.addEventListener('submit', (e) => {
    e.preventDefault();
    updateRow();
    modal.hide();
  });
});


document.getElementById('refreshButton').addEventListener('click', function() {
  location.reload(); 
});
