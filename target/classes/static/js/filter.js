document.querySelector('.search-btn').addEventListener('click', function() {
  const searchTerm = document.querySelector('input[type="search"]').value.toLowerCase(); 
  const estudio = document.querySelector('#estudio').value;
  const fechaInicio = document.querySelector('#inicio').value;
  const fechaFin = document.querySelector('#fin').value;

  const startDate = fechaInicio ? new Date(fechaInicio) : null;
  const endDate = fechaFin ? new Date(fechaFin) : null;

  const rows = document.querySelectorAll('#table-body tr');

  rows.forEach(row => {
    const paciente = row.cells[2].textContent.toLowerCase(); 
    
    const fechaCapturaObj = new Date(fechaCaptura.split('/').reverse().join('-')); 

    let isVisible = true;

    if (searchTerm && !paciente.includes(searchTerm)) {
      isVisible = false;  
    }

    if (estudio !== 'Estudio' && estudio !== '' && row.cells[3].textContent.trim() !== estudio) {
      isVisible = false;  
    }

    if (startDate && fechaCapturaObj.getTime() !== startDate.getTime()) {
      isVisible = false; 

    if (endDate && fechaCapturaObj.getTime() !== endDate.getTime()) {
      isVisible = false; 
    }

    row.style.display = isVisible ? '' : 'none';
}
});
  

  const modal = bootstrap.Modal.getInstance(document.getElementById('exampleModal'));
  modal.hide();
});




console.log('searchTerm:', searchTerm);
console.log('Paciente:', paciente);
console.log('Fecha de captura:', fechaCaptura);
console.log('Fecha de inicio:', startDate);
console.log('Fecha de fin:', endDate);
console.log('Estudio:', estudio);

