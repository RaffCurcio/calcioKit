<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Prodotto"%>
<%@ page import="model.Cliente"%>
<%@ page import="java.util.List"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="model.Composizione"%>
<%@ page import="com.google.gson.JsonArray"%>
<%@ page import="com.google.gson.JsonParser"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Cart Items</title>
<script src="script/jquery-3.7.0.min.js"></script>

<link rel="stylesheet" type="text/css" href="styles/cart.css">
<script type="text/javascript">
	$(document).ready(function() {
		$('.prodotto-quantita').on('input', function() {
			var quantita = $(this).val();
			var prodottoId = $(this).data('prodotto-id');
			var tr = $(this).closest('tr');
			var errorText = tr.find('.error-text');
			errorText.text('');

			// Check if quantita is below 1
			if (quantita < 1 or quantita > 10) {
				errorText.text('la quantità deve essere maggiore di 1 e minore di 11.');
				return;
			}

			// Update the quantita value in the session using AJAX
			$.ajax({
				url : 'update-quantita',
				type : 'POST',
				dataType : 'json',
				contentType : 'application/json',
				data : JSON.stringify({
					quantita : quantita,
					prodottoId : prodottoId
				}),
				success : function(response) {
					if (response.success) {
						// Quantity updated successfully in the session
						// Update the displayed quantita in the table
						tr.find('.prodotto-quantita').val(quantita);
						window.location.href = 'Cart';
					} else {
						// Handle error message if needed
						errorText.text(response.message);
					}
				},
				error : function() {
					// Handle error if the request fails
					errorText.text('An error occurred updating the quantita.');
				}
			});
		});
	});
</script>
</head>
<body>
	<jsp:include page="fragments/Header.jsp" />

	<div class="container">
		<h1 style="text-align: center">Carrello</h1>

		<%
		List<Composizione> composizioni = null;
		if (((Cliente) session.getAttribute("cliente")) == null) {
			composizioni = (List<Composizione>) session.getAttribute("guestCart");

		} else {
			composizioni = (List<Composizione>) session.getAttribute("carrello");

		}
		if (composizioni == null || composizioni.isEmpty()) {
		%>
		<p class="empty-cart-msg">
			Il tuo carrello è vuoto.<br> <a href="/calcioKit/HomePage">Continua ad acquistare</a>
		</p>
		<%
		} else {
		%>
		<table class="cart-table">
			<caption>Oggetti nel carrello</caption>

			<thead>
				<tr>
					<th>Prodotto</th>
					<th>Prezzo</th>
					<th>Quantità</th>
					<th>Subtotale</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < composizioni.size(); i++) {
					// Retrieve the prodotto information from the JSON array

					JsonArray cartItemsJson = new JsonParser().parse(request.getAttribute("composizioniJson").toString())
					.getAsJsonArray();
					Prodotto prodotto = new Gson().fromJson(cartItemsJson.get(i), Prodotto.class);
					int quantita = composizioni.get(i).getQuantita_prodotto();
					BigDecimal subtotal = prodotto.getPrezzo().multiply(BigDecimal.valueOf(quantita));
				%>
				<tr>
					<td>
						<div class="prodotto-details">
							<img src="<%=prodotto.getPath_immagine()%>"
								alt="<%=prodotto.getNomeProdotto()%>" class="prodotto-image">
							<div>
								<p class="prodotto-name"><%=prodotto.getNomeProdotto()%></p>
								<p><%=prodotto.getDescrizione()%></p>
							</div>
						</div>
					</td>
					<td class="prodotto-price">$<%=prodotto.getPrezzo()%></td>
					<td><input type="number" class="prodotto-quantita"
						data-prodotto-id="<%=composizioni.get(i).getIdProdotto()%>"
						value="<%=quantita%>" min="1" max="10">
						<p class="error-text"></p></td>
					<td class="prodotto-subtotal">$<%=subtotal%></td>
					<td class="remove-item">
						<form action="ServletEliminaProdotto" method="POST">
							<input type="hidden" name="prodottoId"
								value="<%=composizioni.get(i).getIdProdotto()%>">
							<button type="submit">Rimuovi prodotto</button>
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

		<form action="Checkout" method="POST">
			<%
			String sessionToken = (String) session.getAttribute("sessionToken");
			BigDecimal prezzoTotale = (BigDecimal) request.getAttribute("prezzoTotale");
			%>
			<input type="hidden" name="clientToken" value="<%=sessionToken%>">
			<input type="hidden" type="number" name="prezzoTotale"
				value="<%=prezzoTotale%>">

			<div class="cart-summary">
				<p class="cart-total">


					Totale carrello: $<%=prezzoTotale%></p>

				<button type="submit" class="checkout-btn">Procedi al
					checkout</button>
			</div>
		</form>

		<%
		}
		%>
	</div>

	<jsp:include page="fragments/Footer.jsp" />

</body>
</html>
