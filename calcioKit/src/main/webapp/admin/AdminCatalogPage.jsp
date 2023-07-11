<!DOCTYPE html>
<%@ page import="model.Cliente"%>
<%@ page import="java.util.List"%>

<html lang="en">
<head>
<title>Admin Page</title>
<script src="script\jquery-3.7.0.min.js"></script>
<script src="script\asyncForms.js"></script>
<script src="script\adminCatalog.js"></script>

<script src="script\catalog.js"></script>

<link rel="stylesheet" type="text/css" href="styles/adminCatalogPage.css">




<style>
.invalid {
	border: 1px solid red;
}

#buttonDiv {
	text-align: center;
}

#toggleButton {
	cursor: pointer;
	text-align: center;
	font-size: 20px;
}

.hidden {
	display: none;
}
</style>


</head>
<body>
	<%
	String sessionToken = (String) session.getAttribute("sessionToken");

	String clienterole = ((Cliente) session.getAttribute("cliente")).getRuolo_cliente();
	if (!(clienterole.equals("admin"))) {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are not an admin.");
		return;
	}
	%>
	<jsp:include page="../fragments/Header.jsp" />
	<div id="buttonDiv">
		<button id="toggleButton">Mostra Catalogo</button>
	</div>
	<div id="cart-notification"></div>

	<section id="catalog">
		<div class="container-catalog" id="container-catalog">
			<div class="filter-section">
				<form id="filterForm" action="FilterCatalogAdmin" method="POST">
					<input type="hidden" name="clientToken" value="<%=sessionToken%>">
					<label for="minPrice">Prezzo Minimo</label> <input type="range"
						name="minPrice" id="minPrice" value="0" min="0" max="1000"
						step="1"> <input type="number" id="minPriceText" value="0"
						min="0" max="1000" step="1"> <label for="maxPrice">Prezzo Massimo
						</label> <input type="range" name="maxPrice" id="maxPrice"
						value="1000" min="0" max="1000" step="1"> <input
						type="number" id="maxPriceText" value="1000" min="0" max="1000"
						step="any"> <input type="submit" value="Applica Filtro">
				</form>
			</div>
			<div class="prodotto-list">
				<%@ page import="model.Prodotto"%>
				<%@ page import="java.util.List"%>
				<%
				List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("prodotti");
				%>

				<%
				if (prodotti.isEmpty()) {
				%>
				<p class="no-prodotti-msg">Prodotti non disponibili.</p>
				<%
				} else {
				%>
				<%
				for (Prodotto prodotto : prodotti) {
				%>
				<div class="prodotto-item">
					<div class="prodotto-image">
						<form action="ProdottoPage" method="POST">
							<input type="hidden" name="prodottoId"
								value="<%=prodotto.getIdProdotto()%>">
							<div onclick="submitForm(this.parentNode)">
								<img src="<%=prodotto.getPath_immagine()%>"
									alt="<%=prodotto.getNomeProdotto()%>" style="cursor: pointer;"
									class="prodotto-image">
							</div>
						</form>
					</div>



					<div class="prodotto-details">
						<h1>
							Prodotto ID
							<%=prodotto.getIdProdotto()%></h1>

						<form class="prodotto-details-form" action="Update" method="POST">
							<input type="hidden" name="prodottoId"
								value="<%=prodotto.getIdProdotto()%>"> <input
								type="hidden" name="clientToken" value="<%=sessionToken%>">

							<div>
								<label for="name">Nome</label><br> <input type="text"
									name="name" id="name" value="<%=prodotto.getNomeProdotto()%>">
							</div>

							<div>
								<label for="description">Descrizione</label><br>
								<textarea name="description" id="description"><%=prodotto.getDescrizione()%></textarea>
							</div>

							<div>
								<label for="price">Prezzo</label><br> <input type="number"
									name="price" id="price" min=1 max=1000 step="any"
									value="<%=prodotto.getPrezzo()%>">
							</div>
							<div>
								<label for="iva">Iva</label><br> <input type="number"
									name="iva" id="iva" min=1 max=100 step="any"
									value="<%=prodotto.getIva()%>">
							</div>

							<div>
								<label for="imagePath">Path Immagine</label><br> <input
									type="text" name="imagePath" id="imagePath"
									value="<%=prodotto.getPath_immagine()%>">
							</div>

							<div>
								<label for="recommended">Raccomandato</label><br> <input
									type="checkbox" name="recommended" id="recommended"
									<%if (prodotto.isRaccomandato()) {%> checked <%}%>>
							</div>


							<div class="button-container">
								<input type="submit" value="Aggiorna Prodotto">
							</div>
						</form>
						<form action="Remove" method="POST">
							<input type="hidden" name="prodottoId"
								value="<%=prodotto.getIdProdotto()%>"> <input
								type="hidden" name="clientToken" value="<%=sessionToken%>">

							<%
							if (prodotto.isCancellato()) {
							%>
							<input type="submit" value="Aggiungi prodotto"
								onclick="changeButtonLabel(this)">
							<%
							} else {
							%>
							<input type="submit" value="Cancella prodotto"
								onclick="changeButtonLabel(this)">
							<%
							}
							%>
						</form>
					</div>
				</div>
				<%
				}
				%>
				<%
				}
				%>
			</div>
		</div>
	</section>


	<section id="AddProdotto">

		<h1>Aggiungi Prodotto</h1>
		<form class="prodotto-details" action="addProdotto" method="POST"
			id="AddProdottoForm" onsubmit="return validateForm()">
			<div>
				<label for="nameForm">Nome</label><br> <input type="text"
					id="nameForm" name="name" required>
			</div>

			<div>
				<label for="descriptionForm">Descrizione</label><br>
				<textarea id="descriptionForm" name="description" required></textarea>
			</div>


			<div>
				<label for="priceForm">Prezzo</label><br> <input type="number"
					id="priceForm" name="price" step="any" required>
			</div>
			<div>
				<label for="Iva">Iva</label><br> <input type="number"
					id="priceForm" name="iva" step="any" required>
			</div>

			<div>
				<label for="imagePathForm">Path Immagine</label><br> <input
					type="text" id="imagePathForm" name="imagePath" required>
			</div>

			<div>
				<label for="recommendedForm">Raccomandato</label><br> <input
					type="checkbox" id="recommendedForm" name="recommended">
			</div>
			<input type="hidden" name="clientToken" value="<%=sessionToken%>">
			<div class="button-container">
				<input type="submit" value="Aggiungi Prodotto">
			</div>
		</form>

		<%-- Display error message if available --%>
		<%
		String errorMessage = (String) request.getAttribute("errorMessage");
		%>
		<%
		if (errorMessage != null && !errorMessage.isEmpty()) {
		%>
		<p class="error"><%=errorMessage%></p>
		<%
		}
		%>

	</section>


	<jsp:include page="../fragments/Footer.jsp" />

</body>
</html>
