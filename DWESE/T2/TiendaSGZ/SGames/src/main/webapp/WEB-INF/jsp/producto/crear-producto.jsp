<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="org.sgames.model.CategoriaDTO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Producto</title>
    <%@ include file="/WEB-INF/jsp/fragmentos/bootstrap.jspf" %>
</head>
<body class="bg-light">
    <%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>

    <div class="container p-5 d-flex flex-column">
        <h2 class="text-center">CREAR PRODUCTO</h2>
        <form class="form my-5 mx-auto w-25" action="${pageContext.request.contextPath}/sgames/productos/crear/" method="post">
            <div class="d-flex justify-content-between mb-5">
                <label class="my-auto fs-5 fw-semibold">Nombre</label>
                <input class="form-control ms-3" type="text" name="nombre" required>
            </div>
            <div class="d-flex justify-content-between mb-5">
                <label class="my-auto fs-5 fw-semibold">Descripcion</label>
                <input class="form-control ms-3" type="text" name="desc">
            </div>
            <div class="d-flex justify-content-between mb-5">
                <label class="my-auto fs-5 fw-semibold">Precio</label>
                <input class="form-control ms-3 w-25" type="number" step="0.01" name="precio" placeholder="€" required>
            </div>
            <div class="d-flex justify-content-between mb-5">
                <label class="my-auto fs-5 fw-semibold">Categoria</label>
                <select class="form-control ms-3" name="idCat">

                    <%
                        if (request.getAttribute("cats") != null) {
                            List<CategoriaDTO> cats = (List<CategoriaDTO>) request.getAttribute("cats");
                            for (CategoriaDTO cat : cats) {

                    %>

                    <option value="<%= cat.getIdCategoria() %>"><%= cat.getNombre() %></option>

                    <% } } %>

                </select>
            </div>

            <div class="m-auto text-center">
                <button class="btn btn-dark">
                    <a class="text-light link-underline link-underline-opacity-0" href="<%=application.getContextPath()%>/sgames/productos">VOLVER</a>
                </button>
                <input class="btn btn-primary ms-3" type="submit" value="CREAR">
            </div>
        </form>
    </div>

    <%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
