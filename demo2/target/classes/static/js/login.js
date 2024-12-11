const togglePassword = document.getElementById('togglePassword');
const passwordField = document.getElementById('password');
const passwordIcon = document.getElementById('passwordIcon');

togglePassword.addEventListener('click', () => {
    const isPasswordVisible = passwordField.type === 'text';
    passwordField.type = isPasswordVisible ? 'password' : 'text';

    // Cambiar el ícono del ojo
    passwordIcon.src = isPasswordVisible 
        ? '../../assets/images/icons-login/eye-closed-icon.svg'
        : '../../assets/images/icons-login/eye-open-icon.svg';
});

/*fetch("https:///login", {
  method: "POST",
  body: JSON.stringify({ 
    usuario: togglePassword,
    password: passwordField
     }),
  headers: {
    "Content-type": "application/json; charset=UTF-8"
  }
})
  .then((response) => response.json())
  .then((json) => console.log(json));*/


  