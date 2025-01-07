<%@ page import="java.time.LocalDate" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Pedido</title>
    <%@ include file="/WEB-INF/jsp/fragmentos/bootstrap.jspf" %>
</head>
<body class="bg-light">
    <%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>

    <div class="container p-5 d-flex flex-column">
        <h2 class="text-center">CREAR PEDIDO</h2>
        <form class="form my-5 mx-auto w-25" action="${pageContext.request.contextPath}/sgames/pedidos/crear/" method="post">
            <div class="d-flex justify-content-between mb-5">
                <label class="my-auto fs-5 fw-semibold">ID Usuario</label>
                <input class="form-control ms-3 w-25" type="number" name="idUsuario" min="0" required>
            </div>
            <div class="d-flex justify-content-between mb-5">
                <label class="my-auto fs-5 fw-semibold">Fecha</label>
                <input class="form-control ms-3 w-50" type="date" value="<%= LocalDate.now() %>" name="fecha">
            </div>
            <div class="m-auto text-center">
                <button class="btn btn-dark">
                    <a class="text-light link-underline link-underline-opacity-0" href="<%=application.getContextPath()%>/sgames/pedidos">VOLVER</a>
                </button>
                <input class="btn btn-primary ms-3" type="submit" value="CREAR">
            </div>
        </form>
    </div>

    <%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
