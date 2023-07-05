<!DOCTYPE html >
<html lang="en">
<head>
<title>Registration</title>

<link rel="stylesheet" type="text/css"
	href="styles/registrazione.css">
<script src="script/registrazione.js"></script>

</head>
<body>

	<jsp:include page="fragments/Header.jsp" />

	<%
	if (request.getAttribute("errorMessage") != null) {
	%>
	<div class="error">
		<%=request.getAttribute("errorMessage")%>
	</div>
	<%
	}
	%>


	<form id="register_form" action="registrazione" method="POST"
		onsubmit="return validateForm(event)">
	<h1>Registration</h1>

		<label for="username">Username</label> <input type="text"
			id="username" name="username" required><br>
		<div id="usernameError" class="error"></div>

		<label for="email">Email</label> <input type="email" id="email"
			name="email" required><br>
		<div id="emailError" class="error"></div>

		<label for="password">Password</label> <input type="password"
			id="password" name="password" required><br>
		<div id="passwordError" class="error"></div>

		<input type="submit" value="Registrati">

	</form>
	<jsp:include page="fragments/Footer.jsp" />

</body>
</html>
