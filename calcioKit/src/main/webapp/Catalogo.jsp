<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Catalogo Prodotti</title>
</head>
<body>
    <h1>Catalogo Prodotti</h1>
    
    <%-- Importa le classi necessarie --%>
    <%@ page import="model.Prodotto" %>
    
    <%-- Recupera la lista dei prodotti dalla richiesta --%>
     <%@ page import="java.util.List" %>
    
    <% List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("prodotti"); %>
    
    <%-- Mostra i prodotti nel catalogo --%>
    <% if (prodotti == null || prodotti.isEmpty()) { %>
        <p>Nessun prodotto disponibile</p>
    <% } else { %>
        <ul>
            <% for (Prodotto prodotto : prodotti) { %>
                <li>
                    <strong><%= prodotto.getNomeProdotto() %></strong><br>
                    Prezzo: <%= prodotto.getPrezzo() %><br>
                    Descrizione: <%= prodotto.getDescrizione() %><br>
                    IVA: <%= prodotto.getIva() %><br>
                    Catalogo: <%= prodotto.getNomeCatalogo() %><br>
                </li>
            <% } %>
        </ul>
    <% } %>
</body>
</html>
