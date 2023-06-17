<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Registrazione - Sito di vendita maglie da calcio</title>
  <link rel="stylesheet" type="text/css" href="styles/Registrazione.css?ts=<?=time()?>&quot">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
	<jsp:include page="fragments/Header.jsp"/>
	
<form class="register_form" action="registrazione" method="post">
	<h1>CREA UN ACCOUNT</h1>
	<%
	if (request.getAttribute("errorMessage") != null) {
	%>
	<div class="error">
		<%=request.getAttribute("errorMessage")%>
	</div>
	<%
	}
	%>
<form action="registrazione" method="post">
    <label for="username">Username:</label>
    <input type="text" placeholder="Inserire username" id="username" name="username" required>
    
    <label for="password">Password:</label>
    <input type="password" placeholder="Inserire password" id="password" name="password" required>
    
    <label for="email">Email:</label>
    <input type="email" placeholder="Inserire e-mail" id="email" name="email" required>
    
    
    
    <input type="submit" value="Registrati">
    
    <p id="Login_text">Hai gia un account? <a href="Login.jsp">Login</a></p>
  </form>
  
  <%-- Verifica se sono presenti parametri POST per la registrazione --%>
  <%
    if (request.getMethod().equalsIgnoreCase("POST")) {
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      String email = request.getParameter("email");
    
      
      // Esegui il codice per la registrazione nel database
      
      // Esempio di messaggio di conferma
  %>
  
  <% } %>

<script type="text/javascript" src="script/registrazione.js"></script>
<jsp:include page="fragments/Footer.jsp"/>
</body>
</html>
