<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
            padding: 0;
            background-color: lightcyan;
            font-family: "Bookman Old Style";
        }
        main {
            display: flex;
            align-items: center;
            justify-content: center;
        }
        main div {
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        main p {
            margin-top: 45%;
            font-size: 20px;
        }
        <%@ include file="/WEB-INF/jsp/fragmentos/estilos.jspf" %>
    </style>
</head>
<body>
    <%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
    <%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>
    <main>
        <div>
            <p>En este lugar va a mostrarse el contenido de la web tras redirigirse</p>
        </div>
    </main>

<%@include file="boostrap.jspf"%>
<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
