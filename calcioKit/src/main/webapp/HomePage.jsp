<!DOCTYPE html>
<html>
<head>
<title>Maglie da calcio - Sito di vendita</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="styles/homepage.css">

<link rel="stylesheet" type="text/css" href="styles/Navbar.css">



</head>
<body>

	<jsp:include page="fragments/Header.jsp" />



	<!-- CONTENUTO PAGINA -->
<h1 style="text-align:center;">Prodotti Raccomandati</h1>

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
		<%
		for (Prodotto prodotto : prodotti) {
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
		<%
		}
		}
		%>
	</div>

	<jsp:include page="fragments/Footer.jsp" />

</body>
</html>