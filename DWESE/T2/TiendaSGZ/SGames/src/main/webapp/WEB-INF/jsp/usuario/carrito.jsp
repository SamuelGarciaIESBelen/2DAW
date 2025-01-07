<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="org.sgames.model.Producto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Carrito</title>
    <%@ include file="/WEB-INF/jsp/fragmentos/bootstrap.jspf" %>
</head>
<body class="bg-light">
    <%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>

    <%
        List<Producto> prodsCarrito = (List<Producto>)request.getAttribute("prodsCarrito");
        Map<Integer,Integer> carritoMap = (Map<Integer,Integer>)request.getAttribute("carritoMap");
        double total = (double)request.getAttribute("total");
    %>

    <div class="container p-5">
        <h2>Carrito</h2>

        <div class="d-flex justify-content-between">

        <%
            if (prodsCarrito != null && !prodsCarrito.isEmpty()) {
        %>

            <table class="table table-striped table-hover me-5">
                <thead class="table-dark">
                    <tr>
                        <th>Producto</th>
                        <th>Precio / Unidad</th>
                        <th>Cantidad</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        for (Producto prod : prodsCarrito) {
                            int cantidad = carritoMap.get(prod.getIdProducto());
                    %>

                    <tr>
                        <td><%= prod.getNombre() %></td>
                        <td><%= prod.getPrecio() %> €</td>
                        <td class="d-flex">
                            <form action="<%=request.getContextPath()%>/sgames/carrito" method="post">
                                <input type="hidden" name="idProd" value="<%=prod.getIdProducto()%>"/>
                                <input class="form-control" type="number" name="cantidad" value="<%=cantidad%>" min="1"/>
                                <input type="hidden" name="__method__" value="put"/>
                                <button type="submit" class="btn btn-warning ms-2">Actualizar</button>
                            </form>
                            <form action="<%=request.getContextPath()%>/sgames/carrito" method="post">
                                <input type="hidden" name="idProd" value="<%=prod.getIdProducto()%>"/>
                                <input type="hidden" name="__method__" value="delete"/>
                                <button type="submit" class="btn btn-danger">Eliminar</button>
                            </form>
                        </td>
                    </tr>

                    <% } %>

                </tbody>
            </table>

            <% } else { %>

            <p class="fs-5">No hay productos en el carrito.</p>

            <% } %>

            <div class="w-fit text-center p-4 border border-2 border-primary rounded-3">
                <h4>Total: <%= total %> €</h4>
                <form class="text-center mt-3" action="<%=request.getContextPath()%>/sgames/carrito" method="post">
                    <input type="hidden" name="__method__" value="confirmar"/>
                    <input class="btn btn-primary" type="submit" value="CONFIRMAR">
                </form>
            </div>
        </div>

    <%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
