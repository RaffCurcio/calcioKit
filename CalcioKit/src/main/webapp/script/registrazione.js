document.addEventListener('DOMContentLoaded', function() {
    var form = document.querySelector('form');
    var usernameInput = document.getElementById('username');
    var passwordInput = document.getElementById('password');
    var emailInput = document.getElementById('email');
    
    form.addEventListener('submit', function(event) {
      var isValid = true;
      
      // Validazione campo username
      if (!usernameInput.value) {
        displayErrorMessage(usernameInput, 'Inserisci un username.');
        isValid = false;
      } else {
        clearErrorMessage(usernameInput);
      }
      
      // Validazione campo password
      if (!passwordInput.value) {
        displayErrorMessage(passwordInput, 'Inserisci una password.');
        isValid = false;
      } else {
        clearErrorMessage(passwordInput);
      }
      
      // Validazione campo email
      var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      if (!emailInput.value || !emailPattern.test(emailInput.value)) {
        displayErrorMessage(emailInput, 'Inserisci un indirizzo email valido.');
        isValid = false;
      } else {
        clearErrorMessage(emailInput);
      }
      
      if (!isValid) {
        event.preventDefault(); // Impedisce l'invio del form se non è valido
      }
    });
    
    // Funzione per visualizzare un messaggio di errore
    function displayErrorMessage(input, message) {
      var errorElement = document.createElement('span');
      errorElement.classList.add('error-message');
      errorElement.textContent = message;
      
      input.classList.add('error');
      
      var parentElement = input.parentElement;
      parentElement.appendChild(errorElement);
    }
    
    // Funzione per rimuovere un messaggio di errore
    function clearErrorMessage(input) {
      input.classList.remove('error');
      
      var parentElement = input.parentElement;
      var errorElement = parentElement.querySelector('.error-message');
      if (errorElement) {
        parentElement.removeChild(errorElement);
      }
    }
  });