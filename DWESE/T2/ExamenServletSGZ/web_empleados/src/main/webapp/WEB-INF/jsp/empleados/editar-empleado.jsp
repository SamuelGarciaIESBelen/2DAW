<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="org.iesbelen.model.Empleado" %>
<%@ page import="java.util.Optional" %>
<%@ page import="org.iesbelen.model.Departamento" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Empleado</title>
    <style>
        <%@ include file="/WEB-INF/jsp/fragmentos/estilos.jspf" %>
    </style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;">
    <form action="${pageContext.request.contextPath}/empresa/empleados/editar/" method="post">
        <input type="hidden" name="__method__" value="put" />
        <div class="clearfix">
            <div style="float: left; width: 50%">
                <h1>Editar Empleado</h1>
            </div>
            <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

                <div style="position: absolute; left: 39%; top : 39%;">
                    <input type="submit" value="Editar"/>
                </div>

            </div>
        </div>

        <div class="clearfix">
            <hr/>
        </div>

        <% 	Optional<Empleado> optEmp = (Optional<Empleado>)request.getAttribute("empleado");
            if (optEmp.isPresent()) {
        %>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Código
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="codigo" value="<%= optEmp.get().getCodigo() %>" readonly/>
            </div>
            <div style="float: left;width: 50%">
                NIF
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="nif" value="<%= optEmp.get().getNif() %>"/>
            </div>
            <div style="float: left;width: 50%">
                Nombre
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="nombre" value="<%= optEmp.get().getNombre() %>"/>
            </div>
            <div style="float: left;width: 50%">
                Primer apellido
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="apellido1" value="<%= optEmp.get().getApellido1() %>"/>
            </div>
            <div style="float: left;width: 50%">
                Segundo apellido
            </div>
            <% if (optEmp.get().getApellido2() == null) { %>
                <div style="float: none;width: auto;overflow: hidden;">
                    <input name="apellido2" value="No tiene"/>
                </div>
            <% } else { %>
                <div style="float: none;width: auto;overflow: hidden;">
                    <input name="apellido2" value="<%= optEmp.get().getApellido2() %>"/>
                </div>
            <% } %>
            <div style="float: left;width: 50%">
                Departamento
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <select name="codFab">
                    <%
                        if (request.getAttribute("listaDepartamentos") != null) {
                            List<Departamento> listaDepartamentos = (List<Departamento>) request.getAttribute("listaDepartamentos");
                            for (Departamento dep : listaDepartamentos) {
                    %>
                    <option value="<%= dep.getCodigo() %>"><%= dep.getNombre() %></option>
                    <% } } %>
                    <option value="0">No tiene</option>
                </select>
            </div>
        </div>

        <% 	} else { %>
            request.sendRedirect("empleados/");
        <% 	} %>

    </form>
</div>
</body>
</html>
