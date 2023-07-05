
<%@ page import="model.Cliente"%>
<!DOCTYPE html>
<html>
<head>
    <title>Elenco Ordini</title>	
    <link rel="stylesheet" type="text/css" href="styles/ordini.css">
    
    <%
	String sessionToken = (String) session.getAttribute("sessionToken");

	Cliente cliente = ((Cliente) session.getAttribute("cliente"));
	if (cliente == null) {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are not logged in.");
		return;
	}
	%>
    <script src="script/jquery-3.7.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $.ajax({
                url: "Ordini",
                type: "GET",
                dataType: "json",
                success: function(response) {
                    // Aggiungi gli ordini alla tabella
                    var table = $("#ordiniTable");
                    $.each(response, function(key, order) {
                        var row = "<tr>" +
                            "<td>" + order.orderId + "</td>" +
                            "<td>" + order.orderDate + "</td>" +
                            "<td>" + order.totalAmount + "</td>" +
                            "<td>" + order.orderStatus + "</td>" +
                            "</tr>";

                        // Aggiungi le composizioni per l'ordine corrente
                        if (order.composizioni.length > 0) {
                            row += "<tr>" +
                                "<td colspan='4'>" +
                                "<table>" +
                                "<tr>" +
                                "<th>Prodotto</th>" +
                                "<th>Quantità</th>" +
                                "<th>Prezzo</th>" +
                                "<th>Immagine</th>" +
                                "</tr>";

                            $.each(order.composizioni, function(index, composition) {
                                row += "<tr>" +
                                    "<td>" + composition.product.name + "</td>" +
                                    "<td>" + composition.quantity + "</td>" +
                                    "<td>" + composition.price + "</td>" +
                                    "<td><img src='" + composition.product.image + "'></td>" +
                                    "</tr>";
                            });

                            row += "</table>" +
                                "</td>" +
                                "</tr>";
                        }

                        table.append(row);
                    });
                },
                error: function(xhr, status, error) {
                    console.log("Errore durante il recupero degli ordini.");
                }
            });
        });
    </script>
</head>
<body>
	<jsp:include page="fragments/Header.jsp" />

    <h1>Elenco Ordini</h1>
    <table id="ordiniTable">
        <thead>
            <tr>
                <th>ID Ordine</th>
                <th>Data Ordine</th>
                <th>Totale</th>
                <th>Stato</th>
            </tr>
        </thead>
        <tbody>
            <!-- I dati degli ordini saranno caricati qui tramite Ajax -->
        </tbody>
    </table>
    	<jsp:include page="fragments/Footer.jsp" />
    
</body>
</html>
