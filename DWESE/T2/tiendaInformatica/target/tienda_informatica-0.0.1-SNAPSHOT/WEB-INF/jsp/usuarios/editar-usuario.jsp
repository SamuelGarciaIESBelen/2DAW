<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="org.iesbelen.model.Usuario"%>
<%@page import="java.util.Optional"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Usuario</title>
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

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
    <form action="${pageContext.request.contextPath}/tienda/usuarios/editar/" method="post" >
        <input type="hidden" name="__method__" value="put" />
        <div class="clearfix">
            <div style="float: left; width: 50%">
                <h1>Editar Usuario</h1>
            </div>
            <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

                <div style="position: absolute; left: 39%; top : 39%;">
                    <input type="submit" value="Guardar" />
                </div>

            </div>
        </div>

        <div class="clearfix">
            <hr/>
        </div>

        <% 	Optional<Usuario> optUsuario = (Optional<Usuario>)request.getAttribute("usuario");
            if (optUsuario.isPresent()) {
        %>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                <label>Código</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="codigo" value="<%= optUsuario.get().getIdUsuario() %>" readonly="readonly"/>
            </div>
        </div>
        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                <label>Nombre</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="nombre" value="<%= optUsuario.get().getNombre() %>"/>
            </div>
        </div>
        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                <label>Password</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="password" value="<%= optUsuario.get().getPassword() %>"/>
            </div>
        </div>
        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                <label>Rol</label>
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="rol" value="<%= optUsuario.get().getRol() %>"/>
            </div>
        </div>

        <% 	} else { %>

        request.sendRedirect("usuarios/");

        <% 	} %>
    </form>
</div>

<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
