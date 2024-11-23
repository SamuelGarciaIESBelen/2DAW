<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.List" %>
<%@ page import="org.iesbelen.model.Usuario" %>
<%@ page import="org.iesbelen.dao.UsuarioDAOImpl" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Usuarios</title>
  <style>
    body {
      padding: 0;
      background-color: lightcyan;
    }
    .clearfix::after {
      content: "";
      display: block;
      clear: both;
    }
    <%@ include file="/WEB-INF/jsp/fragmentos/estilos.jspf" %>
  </style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;">
  <div class="clearfix">
    <div style="float: left; width: 50%">
      <h1>Usuarios</h1>
    </div>
    <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

      <div style="position: absolute; left: 39%; top : 39%; display: flex">
        <form action="${pageContext.request.contextPath}/tienda/usuarios/crear">
          <input type="submit" value="Crear">
        </form>
      </div>

    </div>
  </div>
  <div class="clearfix">
    <hr/>
  </div>
  <div class="clearfix">
    <div style="float: left;width: 10%">Código</div>
    <div style="float: left;width: 15%">Nombre</div>
    <div style="float: left;width: 25%">Password</div>
    <div style="float: left;width: 20%">Rol</div>
    <div style="float: left;width: 20%;overflow: hidden;">Acción</div>
  </div>
  <div class="clearfix">
    <hr/>
  </div>
  <%
    if (request.getAttribute("listaUsuarios") != null) {
      List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");

      for (Usuario usuario : listaUsuarios) {
  %>

  <div style="margin-top: 6px;" class="clearfix">
    <div style="float: left;width: 10%"> <%= usuario.getIdUsuario()%> </div>
    <div style="float: left;width: 15%"> <%= usuario.getNombre()%> </div>
    <div style="float: left;width: 25%"> <%= usuario.getPassword()%> </div>
    <div style="float: left;width: 20%"> <%= usuario.getRol()%> </div>
    <div style="float: none;width: auto;overflow: hidden;">
      <form action="${pageContext.request.contextPath}/tienda/usuarios/<%= usuario.getIdUsuario()%>"
            style="display: inline;">
        <input type="submit" value="Ver Detalle"/>
      </form>
      <form action="${pageContext.request.contextPath}/tienda/usuarios/editar/<%= usuario.getIdUsuario()%>"
            style="display: inline;">
        <input type="submit" value="Editar"/>
      </form>
      <form action="${pageContext.request.contextPath}/tienda/usuarios/borrar/" method="post"
            style="display: inline;">
        <input type="hidden" name="__method__" value="delete"/>
        <input type="hidden" name="codigo" value="<%= usuario.getIdUsuario()%>"/>
        <input type="submit" value="Eliminar"/>
      </form>
    </div>
  </div>
  <%
    }
  } else {
  %>
  No hay registros de usuario
  <% } %>
</div>

<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
