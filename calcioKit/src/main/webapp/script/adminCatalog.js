function submitForm(form) {
	form.submit();
}
function changeButtonLabel(button) {
  if (button.value === "Cancella") {
    button.value = "Aggiungi";
  } else if (button.value === "Aggiungi") {
    button.value = "Cancella";
  }
}


document.addEventListener('DOMContentLoaded', function() {

	let container = document.getElementById('container-catalog');

	function toggleDisplay() {
		container.classList.toggle('hidden');
	}

	let toggleButton = document.getElementById('toggleButton');

	toggleButton.addEventListener('click', toggleDisplay);
});

function validateForm() {
	let nameInput = document.getElementById('nameForm');
	let descriptionInput = document.getElementById('descriptionForm');
	let priceInput = document.getElementById('priceForm');
	let imagePathInput = document.getElementById('imagePathForm');

	let isValid = true;

	if (nameInput.value.trim() === '') {
		nameInput.classList.add('invalid');
		isValid = false;
	} else {
		nameInput.classList.remove('invalid');
	}

	if (descriptionInput.value.trim() === '') {
		descriptionInput.classList.add('invalid');
		isValid = false;
	} else {
		descriptionInput.classList.remove('invalid');
	}


	let price = parseFloat(priceInput.value);
	if (isNaN(price) || price <= 0) {
		priceInput.classList.add('invalid');
		isValid = false;
	} else {
		priceInput.classList.remove('invalid');
	}

	if (imagePathInput.value.trim() === '') {
		imagePathInput.classList.add('invalid');
		isValid = false;
	} else {
		imagePathInput.classList.remove('invalid');
	}

	return isValid;
}
