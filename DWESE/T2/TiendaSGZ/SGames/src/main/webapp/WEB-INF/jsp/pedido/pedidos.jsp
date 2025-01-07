<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.sgames.model.Pedido"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Pedidos</title>
	<%@ include file="/WEB-INF/jsp/fragmentos/bootstrap.jspf" %>
</head>
<body class="bg-light">
	<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>

	<div class="container p-5 w-50">
		<div class="d-flex justify-content-between">
			<h2>PEDIDOS</h2>
			<form action="${pageContext.request.contextPath}/sgames/pedidos/crear">
				<input class="btn btn-primary" type="submit" value="CREAR" />
			</form>
		</div>
		<table class="table table-striped table-hover text-center align-middle mt-3 mx-auto mb-5">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>USUARIO</th>
					<th>FECHA</th>
					<th>ACCIONES</th>
				</tr>
			</thead>
			<tbody class="table-primary">

			<%
				if (request.getAttribute("peds") != null) {
					List<Pedido> peds = (List<Pedido>)request.getAttribute("peds");

					for (Pedido ped : peds) {
			%>

				<tr>
					<td><%= ped.getIdPedido()%></td>
					<td><%= ped.getIdUsuario()%></td>
					<td><%= ped.getFecha()%></td>
					<td>
						<div class="d-flex justify-content-center">
							<form class="me-3" action="${pageContext.request.contextPath}/sgames/pedidos/<%= ped.getIdPedido()%>">
								<input class="btn btn-info" type="submit" value="DETALLES" />
							</form>
							<form class="me-3" action="${pageContext.request.contextPath}/sgames/pedidos/editar/<%= ped.getIdPedido()%>">
								<input class="btn btn-warning" type="submit" value="EDITAR" />
							</form>
							<form action="${pageContext.request.contextPath}/sgames/pedidos/borrar/" method="post">
								<input type="hidden" name="__method__" value="delete"/>
								<input type="hidden" name="codigo" value="<%= ped.getIdPedido()%>"/>
								<input class="btn btn-danger" type="submit" value="ELIMINAR" />
							</form>
						</div>
					</td>
				</tr>

			<%
					}
				} else {
			%>

			<p>No hay registros de pedido</p>

			<% } %>

			</tbody>
		</table>
	</div>
	<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
