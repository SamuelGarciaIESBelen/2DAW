<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
  String[] nombres = {
          "Ballena",
          "Hipocampo",
          "Camello",
          "Cebra",
          "Elefante",
          "Hipopótamo",
          "Jirafa",
          "León",
          "Leopardo",
          "Medusa",
          "Mono",
          "Oso",
          "Oso polar",
          "Pájaro",
          "Pingüino",
          "Rinoceronte",
          "Serpiente",
          "Tigre",
          "Tortuga",
          "Tortuga marina"
  };
  String[] imgs = {
          "ballena.svg",
          "caballito-mar.svg",
          "camello.svg",
          "cebra.svg",
          "elefante.svg",
          "hipopotamo.svg",
          "jirafa.svg",
          "leon.svg",
          "leopardo.svg",
          "medusa.svg",
          "mono.svg",
          "oso.svg",
          "oso-blanco.svg",
          "pajaro.svg",
          "pinguino.svg",
          "rinoceronte.svg",
          "serpiente.svg",
          "tigre.svg",
          "tortuga.svg",
          "tortuga-marina.svg"
  };
  int random = (int)(Math.random() * 20);
%>

<!DOCTYPE html>
<html>
<head>
  <title>Animales</title>
</head>
<body>
<h1 style="text-align: center">Fotos de animales</h1>
<p style="text-align: center; font-size: 20px">Actualiza la página para cambiar de animal</p>
<br/>
<h2 style="text-align: center"><%= nombres[random] %></h2>
<div style="display: flex">
  <img src="images/<%= imgs[random] %>" alt="Animal aleatorio" style="margin: auto">
</div>
</body>
</html>