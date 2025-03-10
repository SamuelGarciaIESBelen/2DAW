<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="org.iesbelen.model.Producto"%>
<%@page import="java.util.Optional"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle Producto</title>
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

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Detalle Producto</h1>
        </div>
        <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

            <div style="position: absolute; left: 39%; top : 39%;">

                <form action="${pageContext.request.contextPath}/tienda/productos" >
                    <input type="submit" value="Volver" />
                </form>
            </div>

        </div>
    </div>

    <div class="clearfix">
        <hr/>
    </div>

    <% 	Optional<Producto> optFab = (Optional<Producto>)request.getAttribute("producto");
        if (optFab.isPresent()) {
    %>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Código</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= optFab.get().getIdProducto() %>" readonly="readonly"/>
        </div>
    </div>
    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Nombre</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= optFab.get().getNombre() %>" readonly="readonly"/>
        </div>
    </div>
    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Precio</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= optFab.get().getPrecio() %>" readonly="readonly"/>
        </div>
    </div>
    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 50%">
            <label>Código Fabricante</label>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <input value="<%= optFab.get().getCodigo_fabricante() %>" readonly="readonly"/>
        </div>
    </div>

    <% 	} else { %>

    request.sendRedirect("productos/");

    <% 	} %>

</div>

<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
