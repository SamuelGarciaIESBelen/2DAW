<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            font-size: 20px;
        }
        h1 {
            text-align: center;
        }
        form {
            margin: auto;
            border: 2px solid black;
            border-radius: 25px;
            padding: 20px;
        }
        .btn {
            display: flex;
            justify-content: space-evenly;
        }
        input[type="submit"], input[type="reset"] {
            font-size: 20px;
        }
    </style>
</head>
<body>
<h1>Formulario</h1>
<form action="form" method="POST">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre">

    <br><br>

    <label for="apellidos">Apellidos:</label>
    <input type="text" id="apellidos" name="apellidos">

    <br><br>

    <label for="edad">Edad:</label>
    <select id="edad" name="edad">
        <option value="...">...</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
    </select>

    <br><br>

    <label for="peso">Peso:</label>
    <input type="number" id="peso" name="peso" step="0.1"> kg

    <br><br>

    <label>Sexo:</label>
    <input type="radio" id="hombre" name="sexo" value="Hombre">
    <label for="hombre">Hombre</label>
    <input type="radio" id="mujer" name="sexo" value="Mujer">
    <label for="mujer">Mujer</label>

    <br><br>

    <label>Estado Civil:</label>
    <input type="radio" id="soltero" name="estadoCivil" value="Soltero">
    <label for="soltero">Soltero</label>
    <input type="radio" id="casado" name="estadoCivil" value="Casado">
    <label for="casado">Casado</label>
    <input type="radio" id="otro" name="estadoCivil" value="Otro">
    <label for="otro">Otro</label>

    <br><br>

    <label>Aficiones:</label><br>
    <input type="checkbox" id="cine" name="aficiones" value="Cine">
    <label for="cine">Cine</label>
    <input type="checkbox" id="literatura" name="aficiones" value="Literatura">
    <label for="literatura">Literatura</label>
    <input type="checkbox" id="comics" name="aficiones" value="Cómics">
    <label for="comics">Cómics</label>
    <br>
    <input type="checkbox" id="deporte" name="aficiones" value="Deporte">
    <label for="deporte">Deporte</label>
    <input type="checkbox" id="musica" name="aficiones" value="Música">
    <label for="musica">Música</label>
    <input type="checkbox" id="television" name="aficiones" value="Televisión">
    <label for="television">Televisión</label>

    <br><br>

    <div class="btn">
        <input type="submit" value="Enviar">
        <input type="reset" value="Borrar">
    </div>
</form>
</body>
</html>