<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Catalogo</title>
<link rel="stylesheet" type="text/css" href="styles/Catalogo.css">
<script src="scripts/catalogo.js"></script>
</head>
<body>
	<div class="header">
		<!-- Includi il tuo header personalizzato qui -->
		<%@ include file="fragments/Header.jsp"%>
	</div>
	
	<h1>Catalogo Prodotti</h1>
	<!-- ... codice precedente ... -->
	

<div id="catalogoContainer">
<%-- Recupera la lista dei prodotti dalla richiesta --%>
		<%@ page import="java.util.List"%>
		<%@ page import="model.Prodotto"%>
		<%
		List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("prodotti");
		%>

		<%-- Mostra i prodotti nel catalogo --%>
		<%
		if (prodotti == null || prodotti.isEmpty()) {
		%>
		<p>Nessun prodotto disponibile</p>
		<%
		} else {
		%>
  <% for (Prodotto prodotto : prodotti) { %>
    <div class="prodotto">
      <a href="ProductDetailsServlet?id=<%= prodotto.getIdProdotto() %>">
        <script type="text/javascript" src="script/imageZoom.js"></script>
    	<img onmouseover="bigImg(this)" onmouseout="normalImg(this)" border="0" src="<%= prodotto.getPath_immagine() %>" height="180" width="180">
      </a>
      <h2><%= prodotto.getNomeProdotto() %></h2>
      <p>Prezzo: <%= prodotto.getPrezzo() %></p>
      <p>Descrizione: <%= prodotto.getDescrizione() %></p>
      <button onclick="aggiungiAlCarrello(<%= prodotto.getIdProdotto() %>)" action>Aggiungi al carrello</button>
    </div>
  <% }} %>
</div>

<!-- ... codice successivo ... -->

	</div>
	<div class="footer">
		<!-- Includi il tuo footer personalizzato qui -->
		<%@ include file="fragments/Footer.jsp"%>
	</div>
</body>
</html>
