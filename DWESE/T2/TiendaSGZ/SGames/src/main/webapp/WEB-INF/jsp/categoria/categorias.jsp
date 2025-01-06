<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.iesbelen.model.FabricanteDTO"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Fabricantes</title>
	<style>
		body {
			background-color: lightcyan;
		}
		.clearfix::after {
			content: "";
			display: block;
			clear: both;
		}
		<%@ include file="/WEB-INF/jsp/fragmentos/estilos.jspf" %>
	</style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>

	<div id="contenedora" style="float:none; margin: 0 auto; width: 900px;" >
		<div class="clearfix">
			<div style="float: left; width: 50%">
				<h1>Fabricantes</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				<div style="position: absolute; left: 39%; top : 39%;">
					
					<form style="margin-bottom: 5px" action="${pageContext.request.contextPath}/tienda/fabricantes/crear">
						<input type="submit" value="Crear">
					</form>
				</div>
				
			</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
		<div class="clearfix">
			<div style="float: left;width: 25%">Código</div>
			<div style="float: left;width: 25%">Nombre</div>
			<div style="float: left;width: 25%">Productos</div>
			<div style="float: none;width: auto;overflow: hidden;">Acción</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
	<%
        if (request.getAttribute("listaFabricantesDTO") != null) {
            List<FabricanteDTO> listaFabricanteDTO = (List<FabricanteDTO>)request.getAttribute("listaFabricantesDTO");
            
            for (FabricanteDTO fab : listaFabricanteDTO) {
    %>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 25%"><%= fab.getIdFabricante()%></div>
			<div style="float: left;width: 25%"><%= fab.getNombre()%></div>
			<div style="float: left;width: 25%"><%= fab.getNumProductos()%></div>
			<div style="float: none;width: auto;overflow: hidden;">
				<form action="${pageContext.request.contextPath}/tienda/fabricantes/<%= fab.getIdFabricante()%>" style="display: inline;">
    				<input type="submit" value="Ver Detalle" />
				</form>
				<form action="${pageContext.request.contextPath}/tienda/fabricantes/editar/<%= fab.getIdFabricante()%>" style="display: inline;">
    				<input type="submit" value="Editar" />
				</form>
				<form action="${pageContext.request.contextPath}/tienda/fabricantes/borrar/" method="post" style="display: inline;">
					<input type="hidden" name="__method__" value="delete"/>
					<input type="hidden" name="codigo" value="<%= fab.getIdFabricante()%>"/>
    				<input type="submit" value="Eliminar" />
				</form>
			</div>
		</div>
	<%
			}
        } else { 
    %>
		No hay registros de fabricante
	<% } %>
	</div>
	<div style="margin-left: 60%; margin-top: 75px">
		<form action="${pageContext.request.contextPath}/tienda/fabricantes">
			<select name="ordenar-por">
				<option value="codigo">Código</option>
				<option value="nombre">Nombre</option>
			</select>
			<select style="margin-left: 5px" name="modo-ordenar">
				<option value="asc">Ascendente</option>
				<option value="desc">Descendente</option>
			</select>
			<input style="margin-left: 5px" type="submit" value="Ordenar">
		</form>
	</div>
<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
