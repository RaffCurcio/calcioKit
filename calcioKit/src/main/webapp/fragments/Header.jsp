<link rel="stylesheet" type="text/css" href="styles/header.css">
<script>
document.querySelector('.toggle-btn').addEventListener('click', function() {
  var navbar = document.querySelector('.navbar');
  navbar.classList.toggle('show');
});
</script>
<nav>
  <div class="navbar">
    <div class="left-menu">
      <a href="HomePage" class="login"><img src="img/house-svgrepo-com.svg" alt="Homepage" width="24" height="24">Home</a>
      <a href="Catalogo" class="login"><img src="img/football-jersey-svgrepo-com.svg" alt="Catalogo" width="24" height="24">Catalogo</a>
    </div>

    <div class="center-menu">
      <a href="Cart" class="cart"><img src="img/cart.svg" alt="cart" width="24" height="24">Carrello</a>
    </div>

    <div class="right-menu">
      <%@ page import="model.Cliente"%>

      <%
      if (session.getAttribute("cliente") == null) {
      %>
      <a href="Login.jsp" class="login"><img src="img/user_logout.svg" alt="cart" width="24" height="24">Login</a>
      <a href="Registrazione.jsp" class="Registrati"><img src="img/user_logout.svg" alt="cart" width="24" height="24">Registrati</a>
      <%
      } else {
      %>
      <a href="ProfiloUtente.jsp" class="Profilo"><img src="img/user_login.svg" alt="Profilo" width="24" height="24">Profilo</a>
      <a href="Ordini.jsp" class="Ordini"><img src="img/order-svgrepo-com.svg" alt="Ordini" width="24" height="24">Ordini</a>
      <a href="logout" class="Logout"><img src="img/user_logout.svg" alt="Logout" width="24" height="24">Logout</a>
      <%
      }

      Cliente cliente = (Cliente) session.getAttribute("cliente");

      if (cliente != null) {
        if (cliente.getRuolo_cliente().equals("admin")) {
      %>
      <a href="AdminCatalogPage" class="Logout"><img src="img/admin-with-cogwheels-svgrepo-com.svg" alt="cart" width="24" height="24">Pagina Catalogo Admin</a>
      <a href="AdminOrdinePage" class="Logout"><img src="img/admin-with-cogwheels-svgrepo-com.svg" alt="cart" width="24" height="24">Pagina Ordini Admin</a>
      <%
      }
      } %>
    </div>

    <div class="toggle-btn">
      <a href="#"><i class="ri-menu-line"></i></a>
    </div>
  </div>
</nav>
