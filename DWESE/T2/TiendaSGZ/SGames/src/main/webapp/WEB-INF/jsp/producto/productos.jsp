<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="org.sgames.model.Producto"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Productos</title>
    <%@ include file="/WEB-INF/jsp/fragmentos/bootstrap.jspf" %>
</head>
<body class="bg-light">
    <%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>

    <%
        if (userLogin != null && "Admin".equals(userLogin.getRol())) {
    %>

    <div class="container p-5">
        <form action="${pageContext.request.contextPath}/sgames/productos/">
            <div class="d-flex mb-3 w-50">
                <input class="form-control w-25 me-3" type="text" name="filter" placeholder="Por nombre...">
                <input class="btn btn-info" type="submit" value="Filtrar">
            </div>
        </form>

    <% } else { %>

    <div class="container p-5 w-75">
        <form action="${pageContext.request.contextPath}/sgames/productos/">
            <div class="d-flex mb-3 w-75">
                <input class="form-control w-25 me-3" type="text" name="filter" placeholder="Por nombre...">
                <input class="btn btn-info" type="submit" value="Filtrar">
            </div>
        </form>
    <% } %>

        <div class="d-flex justify-content-between">
            <h2>PRODUCTOS</h2>

            <%
                if (userLogin != null && "Admin".equals(userLogin.getRol())) {
            %>

            <form action="${pageContext.request.contextPath}/sgames/productos/crear">
                <input class="btn btn-primary" type="submit" value="CREAR" />
            </form>

            <% } %>

        </div>
        <table class="table table-striped table-hover text-center align-middle mt-3 mx-auto mb-5">
            <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>DESCRIPCION</th>
                <th>CATEGORIA</th>
                <th>PRECIO</th>
                <th>COMPRAR</th>

                <%
                    if (userLogin != null && "Admin".equals(userLogin.getRol())) {
                %>

                <th>ACCIONES</th>

                <% } %>

            </tr>
            </thead>
            <tbody class="table-primary">

            <%
                if (request.getAttribute("prods") != null) {
                    List<Producto> prods = (List<Producto>)request.getAttribute("prods");

                    for (Producto prod : prods) {
            %>

            <tr>
                <td><%= prod.getIdProducto()%></td>
                <td class="text-start"><%= prod.getNombre()%></td>
                <td class="text-start"><%= prod.getDescripcion()%></td>
                <td><%= prod.getIdCategoria()%></td>
                <td><%= prod.getPrecio()%> €</td>
                <td>
                    <form action="">
                        <div class="d-flex justify-content-center">
                            <form class="d-flex" action="${pageContext.request.contextPath}/sgames/pedidos" method="post">
                                <input type="hidden" name="__method__" value="buy"/>
                                <input type="hidden" name="idProd" value="<%=prod.getIdProducto()%>"/>
                                <input type="hidden" name="idCat" value="<%=prod.getIdCategoria()%>"/>
                                <input class="form-control me-2 w-50" type="number" name="cantidad" min="0" max="99" value="1">
                                <input class="btn btn-primary" type="submit" value="AÑADIR">
                            </form>
                        </div>
                    </form>
                </td>

                <%
                    if (userLogin != null && "Admin".equals(userLogin.getRol())) {
                %>

                <td>
                    <div class="d-flex justify-content-center">
                        <form class="me-3" action="${pageContext.request.contextPath}/sgames/productos/<%= prod.getIdProducto()%>">
                            <input class="btn btn-info" type="submit" value="DETALLES" />
                        </form>
                        <form class="me-3" action="${pageContext.request.contextPath}/sgames/productos/editar/<%= prod.getIdProducto()%>">
                            <input class="btn btn-warning" type="submit" value="EDITAR" />
                        </form>
                        <form action="${pageContext.request.contextPath}/sgames/productos/borrar/" method="post">
                            <input type="hidden" name="__method__" value="delete"/>
                            <input type="hidden" name="codigo" value="<%= prod.getIdProducto()%>"/>
                            <input class="btn btn-danger" type="submit" value="ELIMINAR" />
                        </form>
                    </div>
                </td>

                <% } %>

            </tr>

            <%
                }
            } else {
            %>

            <p>No hay registros de producto</p>

            <% } %>

            </tbody>
        </table>
    </div>
    <%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
