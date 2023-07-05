<%@ page import="java.util.List"%>
<%@ page import="model.Cliente"%>
<%@ page import="model.Ordine"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>

<html lang="en">
<head>
<script src="script/jquery-3.7.0.min.js"></script>
<link rel="icon" href="images/icon/TechBuild-16.ico">

<link rel="stylesheet" type="text/css"
	href="/calcioKit/styles/adminOrdinePage.css">
<script src="script\asyncForms.js"></script>

	<link rel="stylesheet" type="text/css" href="styles/adminOrdinesPage.css">
	
<title>Cliente Ordini</title>
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
	<div id="cart-notification"></div>

	<div class="container">

		<section id="Ordini">
			<form action="AdminOrdinePage" method="POST">
				<h1>Ordina per Cliente</h1>
				<select name="selectedUsername" id="clienteId">
					<option value="">Tutti i Clienti</option>
					<%
					List<Cliente> clienteList = (List<Cliente>) request.getAttribute("clienteList");
					for (Cliente cliente : clienteList) {
					%>
					
					<option value="<%=cliente.getUsername()%>"><%=cliente.getUsername()%></option>

					<%
					}
					%>
					
				</select> <br> <br>
				<h1>Ordina per Data</h1>
				<h3>Dal</h3>
				<input type="date" name="fromDate" id="fromDate">
				<h3>Al</h3>
				<input type="date" name="toDate" id="toDate"> <input
					type="submit" value="Applica Filtro"> <input type="hidden"
					name="clientToken" value="<%=sessionToken%>">

			</form>

			<table>
				<caption>Ordini clienti</caption>

				<thead>
					<tr>
						<th>ID Cliente</th>
						<th>Email </th>
						<th>Ordine ID</th>
						<th>Data Ordine</th>
						<th>Totale ordine</th>
						<th>Stato</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Ordine> ordineList = (List<Ordine>) request.getAttribute("ordineList");

					for (Ordine ordine : ordineList) {
					%>
					<tr>
						<td><%=ordine.getUsernameCliente()%></td>
						<td><%=ordine.getEmailCliente()%></td>
						<td><%=ordine.getIdOrdine()%></td>
						<td><%=ordine.getDataInserimento()%></td>
						<td><%=ordine.getPrezzoVendita()%>$</td>
						<td><%=ordine.getStatoOrdine()%></td>
						<td>
							<form action="StatusProdotto" method="POST">
								<input type="hidden" name="clientToken"
									value="<%=sessionToken%>"> <input type="hidden"
									name="orderId" value="<%=ordine.getIdOrdine()%>"> <select
									name="status">
									<option value="Completato">Completato</option>
									<option value="Cancellato">Cancellato</option>
									<option value="In consegna">In consegna</option>
									<option value="Consegnato">Consegnato</option>
								</select> <input type="submit" value="Cambia Status">

							</form>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</section>
	</div>

	<jsp:include page="../fragments/Footer.jsp" />

</body>
</html>

