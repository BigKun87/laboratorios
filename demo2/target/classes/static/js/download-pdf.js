document.querySelectorAll('.download-pdf').forEach(button => {
    button.addEventListener('click', function () {
        const { jsPDF } = window.jspdf; 
        const doc = new jsPDF(); 

        const row = this.closest('tr'); 
        const orderNumber = row.closest('.accordion-item').querySelector('.form-check-label').innerText.trim(); 

        const rowData = Array.from(row.querySelectorAll('td')).map(cell => cell.innerText.trim());

       
        doc.text(`Orden: ${orderNumber}`, 10, 10);

       
        doc.autoTable({
            head: [['Paciente', 'Estudio', 'Entrega', 'Fecha compromiso', 'Alerta', 'Estatus']], 
            body: [rowData], 
            startY: 20 
        });

        doc.save(`${orderNumber}.pdf`);
    });
});