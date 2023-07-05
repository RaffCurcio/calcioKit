<link rel="stylesheet" type="text/css" href="styles/header.css">

<nav>
	<ul class="navbar">
		<li><a href="/calcioKit/HomePage" class="active">Home</a></li>
			<li><a href="Catalogo" class="login"><img
					src="img/football-jersey-svgrepo-com.svg" alt="cart" width="24" height="24">Prodotti</a></li>
	</ul>
	<div class="main">
		
		<ul>
			<li><a href="/calcioKit/Cart" class="cart"><img src="img/cart.svg"
					alt="cart" width="24" height="24">Carrello</a></li>
			<%@ page import="model.Cliente"%>

			<%
			if (session.getAttribute("cliente") == null) {
			%>
			<li><a href="/calcioKit/Login.jsp" class="login"><img
					src="img/user_logout.svg" alt="cart" width="24" height="24">Login</a></li>
			<li><a href="/calcioKit/Registrazione.jsp" class="Registrati"><img
					src="img/user_logout.svg" alt="cart" width="24" height="24">Registrati</a></li>
			<%
			} else {
			%>
			<li><a href="/calcioKit/ProfiloUtente.jsp" class="Profilo"><img
					src="img/user_login.svg" alt="Profilo" width="24" height="24">Profilo</a></li>
			<li><a href="/calcioKit/Ordini.jsp" class="Ordini"><img
					src="img/order-svgrepo-com.svg" alt="Ordini" width="24" height="24">Ordini</a></li>
			<li><a href="/calcioKit/logout" class="Logout"><img
					src="img/user_logout.svg" alt="cart" width="24" height="24">Logout</a></li>

			<%
			}
			%>
			<%
			Cliente cliente = (Cliente) session.getAttribute("cliente");

			if (cliente != null) {
				if (cliente.getRuolo_cliente().equals("admin")) {
			%>
			<li><a href="/calcioKit/AdminCatalogPage" class="Logout"><img
			src="img/admin-with-cogwheels-svgrepo-com.svg" alt="cart" width="24" height="24">Admin Catalog Page</a></li>

			<li><a href="/calcioKit/AdminOrdinePage" class="Logout"><img
			src="img/admin-with-cogwheels-svgrepo-com.svg" alt="cart" width="24" height="24">Admin Orders Page</a></li>
<%

 }
 } %>
		</ul>
	</div>

	<div class="toggle-btn">
		<a href=""><i class="ri-menu-line"></i></a>
	</div>
</nav>