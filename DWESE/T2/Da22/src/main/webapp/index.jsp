<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dados</title>
</head>
<body>
<h1 style="text-align: center">Ordenar dados</h1>
<p style="text-align: center; font-size: 20px">Actualiza la página para tirar de nuevo</p>
<br/>
<h2 style="text-align: center">Tirada de ${tirada.length} dados</h2>
<div style="display: flex; justify-content: center">
    <c:forEach var="i" items="${tirada}">
        <img src="images/${dados[i]}" alt="Dado ${i + 1}">
    </c:forEach>
</div>
<h2 style="text-align: center">Tirada ordenada</h2>
<div style="display: flex; justify-content: center">
    <c:forEach var="i" items="${tiradaOrdenada}">
        <img src="images/${dados[i]}" alt="Dado ${i + 1}">
    </c:forEach>
</div>
</body>
</html>