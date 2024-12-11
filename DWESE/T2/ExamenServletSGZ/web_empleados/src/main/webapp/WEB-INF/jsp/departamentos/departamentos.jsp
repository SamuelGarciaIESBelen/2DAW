<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="org.iesbelen.model.Departamento" %>
<%@page import="org.iesbelen.dto.DepartamentoDTO" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Departamentos</title>
    <style>
        <%@ include file="/WEB-INF/jsp/fragmentos/estilos.jspf" %>
    </style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>

<div id="contenedora" style="float:none; margin: 0 auto; width: 900px;">
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Departamentos</h1>
        </div>
        <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
            <div style="position: absolute; left: 39%; top : 39%;">

                <form style="margin-bottom: 5px" action="${pageContext.request.contextPath}/empresa/departamentos/crear">
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
        <div style="float: left; width: 20%;">Nombre</div>
        <div style="float: left; width: 15%;">Presupuesto</div>
        <div style="float: left; width: 15%;">Gastos</div>
        <div style="float: left; width: 15%;">Empleados</div>
        <div style="float: none; width: auto; overflow: hidden;">Acciones</div>
    </div>
    <div class="clearfix">
        <hr/>
    </div>
    <%
        if (request.getAttribute("listaDepartamentosDTO") != null) {
            List<DepartamentoDTO> listaDep = (List<DepartamentoDTO>) request.getAttribute("listaDepartamentosDTO");

            for (DepartamentoDTO dep : listaDep) {
    %>
    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 10%"><%= dep.getCodigo()%>
        </div>
        <div style="float: left;width: 20%"><%= dep.getNombre()%>
        </div>
        <div style="float: left;width: 15%"><%= dep.getPresupuesto()%>
        </div>
        <div style="float: left;width: 15%"><%= dep.getGastos()%>
        </div>
        <div style="float: left;width: 15%"><%= dep.getNumEmpleados()%>
        </div>
        <div style="float: none;width: auto;overflow: hidden;">
            <form style="display: inline;">
                <input type="submit" value="Ver Detalles"/>
            </form>
            <form style="display: inline;">
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
    No hay registros de Departamento
    <% } %>
    </div>
    <div style="margin-left: 50%; margin-top: 75px">
        <form action="${pageContext.request.contextPath}/tienda/departamentos">
            <input type="number" name="min-pres" min="0" placeholder="Presupuesto mínimo">
            <input type="number" name="max-pres" min="0" placeholder="Presupuesto máximo">
            <input style="margin-left: 5px" type="submit" value="Buscar">
        </form>
    </div>
</body>
</html>
