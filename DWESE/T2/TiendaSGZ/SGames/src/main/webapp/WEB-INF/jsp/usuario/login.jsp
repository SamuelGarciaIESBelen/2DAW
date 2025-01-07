<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <%@ include file="/WEB-INF/jsp/fragmentos/bootstrap.jspf" %>
</head>
<body>
    <%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>

    <div class="container p-5 d-flex flex-column">
        <h2 class="text-center">INICIAR SESION</h2>
        <form class="form mt-5 mx-auto w-25" action="${pageContext.request.contextPath}/sgames/usuarios/login/" method="post">
            <input type="hidden" name="__method__" value="login"/>
            <div class="d-flex justify-content-between mb-5">
                <label class="my-auto fs-5 fw-semibold">Nombre</label>
                <input class="form-control ms-3" type="text" name="nombre" required>
            </div>
            <div class="d-flex justify-content-between mb-5">
                <label class="my-auto fs-5 fw-semibold">Password</label>
                <input class="form-control ms-3" type="password" name="password" required>
            </div>
            <div class="m-auto text-center">
                <button class="btn btn-dark">
                    <a class="text-light link-underline link-underline-opacity-0" href="<%=application.getContextPath()%>">VOLVER</a>
                </button>
                <input class="btn btn-primary ms-3" type="submit" value="ENTRAR">
            </div>
        </form>
    </div>

    <%
        String error = (String)request.getAttribute("error");
        if (error != null) {
    %>

    <p class="text-center text-danger fs-5 mb-5"><%= error %></p>

    <% } %>

    <p class="text-center fs-5">Si no tienes usuario, regístrate aquí</p>
    <div class="d-flex">
        <button class="btn btn-primary m-auto">
            <a class="text-light link-underline link-underline-opacity-0" href="<%=application.getContextPath()%>/sgames/usuarios/crear">REGISTRAR</a>
        </button>
    </div>

    <%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
