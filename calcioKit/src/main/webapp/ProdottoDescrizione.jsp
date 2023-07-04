<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Descrizione Prodotto</title>
<link rel="stylesheet" type="text/css"
	href="styles/ProductDescription.css">
</head>
<body>
	<div class="header">
		<!-- Includi il tuo header personalizzato qui -->
		<%@ include file="fragments/Header.jsp"%>
	</div>
	<h1 style="text-align:center;">Descrizione Prodotto</h1>
	<div class="product-details">
		<%-- Recupera le informazioni del prodotto dalla richiesta --%>
		<%@ page import="model.Prodotto"%>
		<%
		Prodotto prodotto = (Prodotto) request.getAttribute("prodotto");
		%>
		<div class="prodotto">
			<a href="ProductDetailsServlet?id=<%=prodotto.getIdProdotto()%>">
				<script type="text/javascript" src="script/imageZoom.js"></script> <img
				onmouseover="bigImg(this)" onmouseout="normalImg(this)" border="0"
				src="<%=prodotto.getPath_immagine()%>" height="180" width="180">
			</a>
			<h2><%=prodotto.getNomeProdotto()%></h2>
			<span>Prezzo: </span>
			<p class="prezzo"><%=prodotto.getPrezzo()%></p>
			<span>Descrizione:</span> <span class="descrizione"><%=prodotto.getDescrizione()%></span>
			<form action="AggiungiAlCarrello" method="POST">
				<input type="hidden" name="idProdotto"
					value="<%=prodotto.getIdProdotto()%>"> <input type="number"
					name="quantita" value="1" min="1"> <input type="submit"
					value="Add to Cart">
			</form>
		</div>

	</div>
	<div class="footer">
		<!-- Includi il tuo footer personalizzato qui -->
		<%@ include file="fragments/Footer.jsp"%>
	</div>
</body>
</html>
