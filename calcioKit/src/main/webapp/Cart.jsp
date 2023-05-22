<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.Composizione" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<link rel="stylesheet" type="text/css" href="styles/Carrello.css">

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>Carrello</title>
    
    <style>
        /* Stili CSS */
    </style>
</head>
<body>
<jsp:include page="fragments/Header.jsp"/>
    <h1>Carrello</h1>
    
    <%-- Recupera il carrello dalla sessione --%>
    <% List<Composizione> carrello = (List<Composizione>) session.getAttribute("carrello"); %>
    
    <%-- Verifica se il carrello è vuoto --%>
    <% if (carrello == null || carrello.isEmpty()) { %>
        <p class="empty-message">Il carrello è vuoto.</p>
    <% } else { %>
        <%-- Mostra i prodotti del carrello --%>
        <table>
            <tr>
                <th>Prodotto</th>
                <th>Prezzo</th>
                <th>Quantità</th>
                <th>Azioni</th>
               
                
            </tr>
            <% for (Composizione composizione : carrello) { %>
                <tr>
                    <td><%= composizione.getIdProdotto() %></td>
                    <td><%= composizione.getPrezzo_vendita()%></td>
                    <td><%= composizione.getQuantita_prodotto() %></td>
                    <td>
                        <form action="ServletEliminaProdotto" method="post">
                            <input type="hidden" name="idProdotto" value="<%= composizione.getIdProdotto() %>">
                            <button type="submit">Elimina</button>
                        </form>
                    </td>
                    
                </tr>
            <% } %>
        </table>
    <% } %>
    <jsp:include page="fragments/Footer.jsp"/>
</body>
</html>

