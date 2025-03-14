<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="org.iesbelen.model.Fabricante" %>
<%@page import="java.util.List" %>
<%@ page import="org.iesbelen.model.Producto" %>
<%@ page import="org.iesbelen.dao.FabricanteDAOImpl" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Productos</title>
    <style>
        body {
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
            <h1>Productos</h1>
        </div>
        <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

            <div style="position: absolute; left: 39%; top : 39%; display: flex">
                <form style="margin-right: 35px" action="${pageContext.request.contextPath}/tienda/productos/">
                    <input type="text" name="filter" size="10" placeholder="Por nombre...">
                    <input type="submit" value="Filtrar">
                </form>

                <form action="${pageContext.request.contextPath}/tienda/productos/crear">
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
        <div style="float: left;width: 30%">Nombre</div>
        <div style="float: left;width: 10%">Precio</div>
        <div style="float: left;width: 15%">Fabricante</div>
        <div style="float: left;width: 20%;overflow: hidden;">Acción</div>
    </div>
    <div class="clearfix">
        <hr/>
    </div>
    <%
        if (request.getAttribute("listaProductos") != null) {
            List<Producto> listaProducto = (List<Producto>) request.getAttribute("listaProductos");

            for (Producto producto : listaProducto) {
    %>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 10%"><%= producto.getIdProducto()%>
        </div>
        <div style="float: left;width: 30%"><%= producto.getNombre()%>
        </div>
        <div style="float: left;width: 10%"><%= producto.getPrecio()%>
        </div>
        <div style="float: left;width: 15%"><%= producto.getCodigo_fabricante()%>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <form action="${pageContext.request.contextPath}/tienda/productos/<%= producto.getIdProducto()%>"
                  style="display: inline;">
                <input type="submit" value="Ver Detalle"/>
            </form>
            <form action="${pageContext.request.contextPath}/tienda/productos/editar/<%= producto.getIdProducto()%>"
                  style="display: inline;">
                <input type="submit" value="Editar"/>
            </form>
            <form action="${pageContext.request.contextPath}/tienda/productos/borrar/" method="post"
                  style="display: inline;">
                <input type="hidden" name="__method__" value="delete"/>
                <input type="hidden" name="codigo" value="<%= producto.getIdProducto()%>"/>
                <input type="submit" value="Eliminar"/>
            </form>
        </div>
    </div>
    <%
        }
    } else {
    %>
    No hay registros de producto
    <% } %>
</div>

<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
