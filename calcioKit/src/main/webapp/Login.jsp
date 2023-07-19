<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">

<title>Login</title>
<link rel="stylesheet" type="text/css" href="styles/registrazione.css?ts=<?=time()?>&quot"">


</head>
<body>
	<jsp:include page="fragments/Header.jsp"/>

	<form class="login_form" action="login" method="post">
	<h1>Login</h1>
	<%
	if (request.getAttribute("errorMessage") != null) {
	%>
	<div class="error">
		<%=request.getAttribute("errorMessage")%>
	</div>
	<%
	}
	%>
		<div class="form-group">
			<label for="username">Username:</label> <input type="text"
				placeholder="Inserire username" id="username" name="username"
				required>
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				placeholder="Inserire password" id="password" name="password"
				required>
		</div>
		<div class="form-group">
			<input type="submit" value="Login">
		</div>
		<div class="form-group">
			<p class="Login_text">
				Se non sei registrato, <a href="Registrazione.jsp">clicca qui</a>
				per registrarti.
			</p>
		</div>

	</form>
<jsp:include page="fragments/Footer.jsp"/>

</body>
</html>
