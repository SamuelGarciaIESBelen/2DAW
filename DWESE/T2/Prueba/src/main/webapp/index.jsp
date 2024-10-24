<%@ page import="java.sql.SQLOutput" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Hello or Bye World!</h1>
<h1 style="margin-left: 50px"><%= 2 * 3 * 4 * 5 %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
<a href="bye-servlet">Bye Servlet</a>
<br>
<h2 style="margin-left: 10px">FORMULARIO</h2>
<form action="hello-servlet" method="POST" style="margin-left: 10px">
  <label for="nombreInput">Nombre:</label>
  <input type="text" id="nombreInput" name="nombreInput" required>
  <br><br>
  <label for="apellidosInput">Apellido:</label>
  <input type="text" id="apellidosInput" name="apellidosInput" required>
  <br><br>
  <label for="emailInput">Email:</label>
  <input type="text" id="emailInput" name="emailInput" size="25" required>
  <br><br>
  <input type="radio" id="genderM" name="gender" value="1">
  <label for="genderM">Hombre</label>
  <br>
  <input type="radio" id="genderF" name="gender" value="2">
  <label for="genderF">Mujer</label>
  <br><br>
  <label for="mensajeHere">Ingresa aquí tu mensaje</label>
  <br>
  <textarea id="mensajeHere" name="mensajeHere" maxlength="244" cols="56" rows="5"
            placeholder="...Tus mensajes aquí..."></textarea>
  <br><br>
  <label for="ciudad">Procedencia</label>
  <select id="ciudad" name="ciudad">
    <option value="España">España</option>
    <option value="EEUU">EEUU</option>
    <option value="Inglaterra">Inglaterra</option>
    <option value="Mexico">Mexico</option>
    <option value="Colombia">Colombia</option>
    <option value="Otro">Otro</option>
  </select>
  <br><br>
  <div style="margin-left: 120px;">
    <input type="submit" value="Enviar">
    <input type="reset" value="Borrar los datos">
  </div>
</form>
</body>
</html>