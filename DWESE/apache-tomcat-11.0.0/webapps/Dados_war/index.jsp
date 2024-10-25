<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
  int cantidad = (int)(Math.random() * 6) + 2;
  String[] dados = { "1.svg", "2.svg", "3.svg", "4.svg", "5.svg", "6.svg" };
  int[] tirada = new int[cantidad];

  for (int i = 0; i < cantidad; i++) {
    tirada[i] = (int)(Math.random() * 6);
  }

  int[] tiradaOrdenada = Arrays.copyOf(tirada, tirada.length);
  Arrays.sort(tiradaOrdenada);
%>

<!DOCTYPE html>
<html>
<head>
  <title>Dados</title>
</head>
<body>
<h1 style="text-align: center">Ordenar dados</h1>
<p style="text-align: center; font-size: 20px">Actualiza la página para tirar de nuevo</p>
<br/>
<h2 style="text-align: center">Tirada de <%= cantidad %> dados</h2>
<div style="display: flex; justify-content: center">
  <% for (int t : tirada) { %>
    <img src="images/<%= dados[t] %>" alt="Cara <%= t + 1 %>">
  <% } %>
</div>
<h2 style="text-align: center">Tirada ordenada</h2>
<div style="display: flex; justify-content: center">
  <% for (int t : tiradaOrdenada) { %>
    <img src="images/<%= dados[t] %>" alt="Cara <%= t + 1 %>">
  <% } %>
</div>
</body>
</html>