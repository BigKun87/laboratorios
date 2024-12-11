/* Script del wisiwig */

var quill = new Quill('#editor-container', {
    theme: 'snow'
  });



  /* Script de los chpis para el mail */

  document.addEventListener('DOMContentLoaded', () => {
    const chipsContainer = document.querySelector('.chips_input .inner');
    const inputField = chipsContainer.querySelector('input');
    const chipTemplate = (text) => `
      <span class="chip">
        ${text}<button aria-label="remove this chip">&times;</button>
      </span>
    `;
  
    inputField.addEventListener('keydown', (e) => {
      if (e.key === 'Enter' || e.key === ',' || e.key === 'Tab') {
        e.preventDefault();
        const value = inputField.value.trim().replace(/,$/, ''); // Remove trailing comma
        if (value && !isDuplicate(value)) {
          chipsContainer.insertAdjacentHTML('beforeend', chipTemplate(value));
          inputField.value = '';
        }
      }
    });
  
    chipsContainer.addEventListener('click', (e) => {
      if (e.target.closest('button')) {
        e.target.closest('.chip').remove();
      }
    });
  
    function isDuplicate(text) {
      return Array.from(chipsContainer.querySelectorAll('.chip'))
        .some((chip) => chip.textContent.trim() === text);
    }
  });
  