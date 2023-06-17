<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="model.Cliente"%>
<%@ page import="java.util.Date"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html >
<html lang="en">
<head>
<title>Profilo Utente</title>

<link rel="stylesheet" type="text/css" href="styles/ProfiloUtente.css">
</head>
<body>
	<jsp:include page="fragments/Header.jsp" />

	<div class="container-userProfile">
		<div class="profile-section">
			<h1>Cliente Profile</h1>

			<%-- Get the cliente and cliente objects from the session --%>
			<%
			Cliente cliente = (Cliente) session.getAttribute("cliente");
			%>
			

			<div class="profile-details">
				<%-- Display cliente profile information --%>
				<p>
					<strong>Username</strong><br>
					<%=cliente.getUsername()%>
				</p>
				<p>
					<strong>Email</strong><br>
					<%=cliente.getEmail()%>
				</p>
			</div>

			<%-- Display cliente if it is available --%>
			<%
			if (cliente != null) {
			%>
			<div class="profile-details">
				<p>
					<strong>Nome</strong><br>
					<%=cliente.getNome()%>
				</p>
				<p>
					<strong>Cognome</strong><br>
					<%=cliente.getCognome()%>
				</p>
				<p>
					<strong>Città</strong><br>
					<%=cliente.getCitta()%>
				</p>
				<p>
					<strong>Provincia</strong><br>
					<%=cliente.getProvincia()%>
				</p>
				<p>
					<strong>Cap</strong><br>
					<%=cliente.getCap()%>
				</p>
				<p>
					<strong>Indirizzo</strong><br>
					<%=cliente.getIndirizzo()%>
				</p>


			</div>
			<%
			} else {
			%>
			<p>Dettagli cliente non disponibili.</p>
			<%
			}
			%>
		</div>

		<div class="update-section">
			<h2>Modifica profilo</h2>
			<form id="modificaForm" method="post" action="modificaProfilo"
				onsubmit="return validateForm()">
				<label for="nomeInput">Nome</label> <input type="text"
					id="nomeInput" name="nome"
					value="<%=cliente != null ? cliente.getNome() : ""%>" required>
				<div id="nomeError" class="error"></div>

				<label for="cognomeInput">Cognome</label> <input type="text"
					id="cognomeInput" name="cognome"
					value="<%=cliente != null ? cliente.getCognome() : ""%>" required>
				<div id="cognomeError" class="error"></div>

				<label for="indirizzoInput">Indirizzo</label> <input type="text"
					id="indirizzoInput" name="indirizzo"
					value="<%=cliente != null ? cliente.getIndirizzo() : ""%>" required>
				<div id="indirizzoError" class="error"></div>

				<label for="cittaInput">Città</label> <input type="text"
					id="cittaInput" name="citta"
					value="<%=cliente != null ? cliente.getCitta() : ""%>" required>
				<div id="cittaError" class="error"></div>

				<label for="capInput">Cap</label> <input type="text"
					id="capIndirizzo" name="cap"
					value="<%=cliente != null ? cliente.getCap() : ""%>" required>
				<div id="capError" class="error"></div>

				<label for="provinciaInput">Provincia</label> <input type="text"
					id="provinciaInput" name="provincia"
					value="<%=cliente != null ? cliente.getProvincia() : ""%>" required>
				<div id="provinciaError" class="error"></div>


				
				<input type="submit" value="Modifica Profilo">
			</form>
		</div>
	</div>

	<jsp:include page="fragments/Footer.jsp" />

</body>
</body>
<script>
	function validateForm() {
		var nomeInput = document.getElementById("nomeInput");
		var cognomeInput = document.getElementById("cognomeInput");
		var indirizzoInput = document.getElementById("indirizzoInput");
		var cittaInput = document.getElementById("cittaInput");
		var capInput = document.getElementById("capInput");
		var provinciaInput = document.getElementById("provinciaInput");

		var usernameRegex = /^[a-zA-Z]{1,50}$/;
		var indirizzoRegex = /^[a-zA-Z0-9 ]{1,100}$/;
		var capRegex = /^\d{5}$/;

		clearErrors();

		// Validate nome
		if (!usernameRegex.test(nomeInput.value)) {
			showError("nomeError", "Invalid nome");
			return false;
		}

		// Validate cognome
		if (!usernameRegex.test(cognomeInput.value)) {
			showError("cognomeError", "Invalid cognome");
			return false;
		}

		// Validate indirizzo
		if (!indirizzoRegex.test(indirizzoInput.value)) {
			showError("indirizzoError", "Invalid indirizzo");
			return false;
		}

		// Validate citta
		if (!usernameRegex.test(cittaInput.value)) {
			showError("cittaError", "Invalid citta");
			return false;
		}

		// Validate CAP
		if (!capRegex.test(capInput.value)) {
			showError("capError",
					"CAP non valido (deve essere composto da 5 cifre)");
			return false;
		}

		// Validate provincia
		if (!usernameRegex.test(provinciaInput.value)) {
			showError("provinciaError", "Invalid provincia");
			return false;
		}

		return true;
	}

	// Function to display an error message
	function showError(elementId, message) {
		var errorDiv = document.getElementById(elementId);
		errorDiv.innerHTML = message;
		errorDiv.style.display = "block";
	}

	// Function to clear error messages
	function clearErrors() {
		var errorDivs = document.getElementsByClassName("error");
		for (var i = 0; i < errorDivs.length; i++) {
			errorDivs[i].innerHTML = "";
		}
	}
</script>
</html>



