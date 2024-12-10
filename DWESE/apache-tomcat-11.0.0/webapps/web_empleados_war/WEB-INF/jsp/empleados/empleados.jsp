<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.List" %>
<%@ page import="org.iesbelen.model.Empleado" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Empleados</title>
    <style>
        <%@ include file="/WEB-INF/jsp/fragmentos/estilos.jspf" %>
    </style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>

<div id="contenedora" style="float:none; margin: 0 auto; width: 900px;">
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Empleados</h1>
        </div>
        <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
            <div style="position: absolute; left: 39%; top : 39%;">

                <form style="margin-bottom: 5px">
                    <input type="submit" value="Crear">
                </form>
            </div>

        </div>
    </div>
    <div class="clearfix">
        <hr/>
    </div>
    <div class="clearfix">
        <div style="float: left; width: 10%;">Código</div>
        <div style="float: left; width: 15%;">NIF</div>
        <div style="float: left; width: 15%;">Nombre</div>
        <div style="float: left; width: 10%;">Apellido1</div>
        <div style="float: left; width: 10%;">Apellido2</div>
        <div style="float: left; width: 15%;">Departamento</div>
        <div style="float: none; width: auto; overflow: hidden;">Acciones</div>
    </div>
    <div class="clearfix">
        <hr/>
    </div>
    <%
        if (request.getAttribute("listaEmpleados") != null) {
            List<Empleado> listaEmp = (List<Empleado>) request.getAttribute("listaEmpleados");

            for (Empleado emp : listaEmp) {
    %>
    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 10%"><%= emp.getCodigo()%>
        </div>
        <div style="float: left;width: 15%"><%= emp.getNif()%>
        </div>
        <div style="float: left;width: 15%"><%= emp.getNombre()%>
        </div>
        <div style="float: left;width: 10%"><%= emp.getApellido1()%>
        </div>

        <% if (emp.getApellido2() == null) { %>
            <div style="float: left;width: 10%"><i>No tiene</i></div>
        <% } else { %>
            <div style="float: left;width: 10%"> <%= emp.getApellido2()%> </div>
        <% } if (emp.getCodigoDep() == 0) { %>
            <div style="float: left;width: 10%"><i>No tiene</i></div>
        <% } else { %>
            <div style="float: left;width: 15%"><%= emp.getCodigoDep()%> </div>
        <% } %>
        <div style="float: none;width: auto;overflow: hidden;">
            <form style="display: inline;">
                <input type="submit" value="Ver Detalles"/>
            </form>
            <form action="${pageContext.request.contextPath}/empresa/empleados/editar/<%= emp.getCodigo()%>"
                  style="display: inline;">
                <input type="submit" value="Editar"/>
            </form>
            <form style="display: inline;">
                <input type="submit" value="Eliminar"/>
            </form>
        </div>
    </div>
    <%
        }
    } else {
    %>
    No hay registros de Empleado
    <% } %>
    </div>
</body>
</html>
