<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Descrizione Prodotto</title>
  <link rel="stylesheet" type="text/css" href="styles/ProductDescription.css">
</head>
<body>
  <div class="header">
    <!-- Includi il tuo header personalizzato qui -->
    <%@ include file="fragments/Header.jsp" %>
  </div>
  <h1>Descrizione Prodotto</h1>
  <div class="product-details">
    <%-- Recupera le informazioni del prodotto dalla richiesta --%>
    <%@ page import="model.Prodotto" %>
    <% Prodotto prodotto = (Prodotto) request.getAttribute("prodotto"); %>
	<img src="<%= prodotto.getPath_immagine() %>">
    <h2><%= prodotto.getNomeProdotto() %></h2>
    <p>Prezzo: <%= prodotto.getPrezzo() %></p>
    <p>Descrizione: <%= prodotto.getDescrizione() %></p>
    <!-- ... Altre informazioni del prodotto ... -->
    <button onclick="aggiungiAlCarrello(<%= prodotto.getIdProdotto() %>)">Aggiungi al carrello</button>
    
  </div>
  <div class="footer">
    <!-- Includi il tuo footer personalizzato qui -->
    <%@ include file="fragments/Footer.jsp" %>
  </div>
</body>
</html>
