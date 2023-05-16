<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Catalogo - Sito di vendita maglie da calcio</title>
  <link rel="stylesheet" type="text/css" href="styles/catalogo.css">
</head>
<body>
  <h1>Catalogo</h1>
  
  <table>
    <tr>
      <th>Nome</th>
      <th>Prezzo</th>
      <th>Taglia</th>
    </tr>
    <%-- Esempio di iterazione sulle maglie da calcio presenti nel database --%>
    <%
      /*List<MagliaCalcio> maglie = MagliaCalcioDAO.getAllMaglie();
      for (MagliaCalcio maglia : maglie) {*/
    %>
    <tr>
      <td><%= maglia.getNome() %></td>
      <td><%= maglia.getPrezzo() %></td>
      <td><%= maglia.getTaglia() %></td>
    </tr>
    <% } %>
  </table>
</body>
</html>
