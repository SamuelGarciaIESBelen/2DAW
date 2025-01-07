<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.Optional" %>
<%@ page import="org.sgames.model.Usuario" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Usuario</title>
    <%@ include file="/WEB-INF/jsp/fragmentos/bootstrap.jspf" %>
</head>
<body class="bg-light">
    <%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>

    <div class="container p-5 d-flex flex-column">
        <h2 class="text-center">EDITAR USUARIO</h2>

        <% 	Optional<Usuario> optUsuario = (Optional<Usuario>)request.getAttribute("usuario");
            if (optUsuario.isPresent()) {
        %>

        <form class="form my-5 mx-auto w-25" action="${pageContext.request.contextPath}/sgames/usuarios/crear/" method="post">
            <input type="hidden" name="__method__" value="put" />
            <div class="d-flex justify-content-between mb-5">
                <label class="my-auto fs-5 fw-semibold">ID</label>
                <input class="form-control ms-3 w-25" type="text" name="codigo" value="<%= optUsuario.get().getIdUsuario() %>" readonly>
            </div>
            <div class="d-flex justify-content-between mb-5">
                <label class="my-auto fs-5 fw-semibold">Nombre</label>
                <input class="form-control ms-3 w-50" type="text" name="nombre" value="<%= optUsuario.get().getNombre() %>" required>
            </div>
            <div class="d-flex justify-content-between mb-5">
                <label class="my-auto fs-5 fw-semibold">Password</label>
                <input class="form-control ms-3" type="text" name="password" value="<%= optUsuario.get().getPassword().substring(0, 8) + "..." %>" required>
            </div>
            <div class="d-flex justify-content-between mb-5">
                <label class="my-auto fs-5 fw-semibold">Rol</label>
                <select class="form-control ms-3 w-50" name="rol">
                    <option value="Cliente">Cliente</option>
                    <option value="Admin">Admin</option>
                </select>
            </div>
            <div class="m-auto text-center">
                <button class="btn btn-dark">
                    <a class="text-light link-underline link-underline-opacity-0" href="<%=application.getContextPath()%>/sgames/usuarios">VOLVER</a>
                </button>
                <input class="btn btn-primary ms-3" type="submit" value="EDITAR">
            </div>
        </form>
    </div>

    <% 	} else { %>

    request.sendRedirect("usuarios/");

    <% 	} %>

    <%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
