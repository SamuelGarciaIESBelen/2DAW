<%@ page import="org.iesbelen.dao.FabricanteDAOImpl" %>
<%@ page import="org.iesbelen.model.FabricanteDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Producto</title>
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
    <form action="${pageContext.request.contextPath}/tienda/productos/crear/" method="post">
        <div class="clearfix">
            <div style="float: left; width: 50%">
                <h1>Crear Producto</h1>
            </div>
            <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

                <div style="position: absolute; left: 39%; top : 39%;">
                    <input type="submit" value="Crear"/>
                </div>

            </div>
        </div>

        <div class="clearfix">
            <hr/>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Nombre
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="nombre"/>
            </div>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Precio
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="precio"/>
            </div>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Fabricante
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <select name="codFab">
                    <%
                        if (request.getAttribute("listaFabricantes") != null) {
                            List<FabricanteDTO> listaFabricantes = (List<FabricanteDTO>) request.getAttribute("listaFabricantes");
                            for (FabricanteDTO fab : listaFabricantes) {
                    %>
                    <option value="<%= fab.getIdFabricante() %>"><%= fab.getNombre() %></option>
                    <% } } %>
                </select>
            </div>
        </div>

    </form>
</div>

<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
