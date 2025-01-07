<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SGames</title>
    <%@ include file="/WEB-INF/jsp/fragmentos/bootstrap.jspf" %>
</head>
<body class="bg-light">
    <%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
    <div class="container d-flex py-5 mb-5 text-center">
        <div class="m-auto w-50">
            <p class="fs-4 mb-5">En esta web podemos encontrar videojuegos divididos en diferentes categorías y podemos hacer pedidos con distintos usuarios.</p>
            <p class="fs-4 mb-5">Las opciones del back solo son accesibles por los administradores.</p>
            <p class="fs-4 mb-5">No se pueden eliminar las categorias que tengan productos.</p>
            <p class="fs-4">La contraseña de todos los usuarios es 1234.</p>
        </div>
    </div>
    <%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>