<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Login - CalcioKit</title>
<link rel="stylesheet" type="text/css" href="styles/Login.css">
<link rel="stylesheet" type="text/css" href="styles/Homepage.css">

</head>
<body>
<header>
		<div id="logo">
			<img src="img/logo.jpg" alt="Logo del sito" id="ciao">
		</div>
	</header>

	<h1>Login</h1>

	<form action="loginProcess.jsp" method="post">
		<div class="form-group">
			<label for="username">Username:</label>
			<input type="text" id="username" name="username" required>
		</div>
		<div class="form-group">
			<label for="password">Password:</label>
			<input type="password" id="password" name="password" required>
		</div>
		<div class="form-group">
			<input type="submit" value="Login">
		</div>
		<div class="form-group">
			<p>Se non sei registrato, <a href="registrazione.html">clicca qui</a> per registrartia.</p>
		</div>
		
	</form>


</body>
</html>
