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
        <div class="m-auto w-75">
            <p class="fs-4 mb-4">En esta web podemos encontrar videojuegos divididos en diferentes categorías y podemos hacer pedidos con distintos usuarios.</p>
            <p class="fs-4 mb-4">Solo se puede acceder al carrito con la sesion iniciada.</p>
            <p class="fs-4 mb-4">Las opciones relacionadas con el back, usuarios o pedidos solo son accesibles por los administradores.</p>
            <p class="fs-4 mb-4">No se pueden eliminar las categorias que tengan productos.</p>
            <p class="fs-4 mb-4">La contraseña de todos los usuarios es 1234.</p>
            <p class="fs-4">No funciona el carrito, lo he intentado muchas horas y cada cosa que cambiaba lo reventaba más.</p>
        </div>
    </div>
    <%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>