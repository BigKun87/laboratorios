
// Obtener todos los inputs con la clase "code-input"
const codeInputs = document.querySelectorAll('.code-input');
const resultDiv = document.querySelector('.resultOTP'); // Obtener el div para mostrar el resultado

// Agregar un evento 'input' a cada campo de entrada
codeInputs.forEach((input, index) => {
  input.addEventListener('input', () => handleInput(index));
});

function handleInput(index) {
  const currentInput = codeInputs[index];

  // Si se ha ingresado un valor, mover al siguiente campo
  if (currentInput.value.length === 1 && index < codeInputs.length - 1) {
    codeInputs[index + 1].focus();
  }

  // Si se borra un valor, mover al campo anterior
  if (currentInput.value.length === 0 && index > 0) {
    codeInputs[index - 1].focus();
  }

  // Concatenar todos los valores de los inputs en un solo string
  let otpCode = "";
  codeInputs.forEach(input => {
    otpCode += input.value; // Concatenar el valor de cada input
  });

  // Mostrar el código en el div resultOTP
  resultDiv.textContent = otpCode; // Actualizar el contenido del div con el código
}