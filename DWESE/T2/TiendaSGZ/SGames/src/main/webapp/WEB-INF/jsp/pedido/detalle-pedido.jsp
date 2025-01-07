<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@page import="java.util.Optional" %>
<%@ page import="org.sgames.model.Pedido" %>
<%@ page import="org.sgames.model.Producto" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Detalles Pedido</title>
	<%@ include file="/WEB-INF/jsp/fragmentos/bootstrap.jspf" %>
</head>
<body class="bg-light">
	<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>

	<div class="container p-5 d-flex flex-column w-25">
		<h2 class="text-center">DETALLES PEDIDO</h2>

		<%
			Optional<Pedido> optPed = (Optional<Pedido>)request.getAttribute("ped");
			List<Producto> prods = (List<Producto>)request.getAttribute("prods");
			List<Integer> cants = (List<Integer>)request.getAttribute("cants");

			if (optPed.isPresent()) {
		%>

		<div class="mt-5 fs-5">
			<div class="d-flex justify-content-between mb-3">
				<p class="fw-semibold">ID</p>
				<p><%= optPed.get().getIdPedido() %></p>
			</div>
			<div class="d-flex justify-content-between mb-3">
				<p class="fw-semibold">ID Usuario</p>
				<p><%= optPed.get().getIdUsuario() %></p>
			</div>
			<div class="d-flex justify-content-between mb-3">
				<p class="fw-semibold">Fecha</p>
				<p><%= optPed.get().getFecha() %></p>
			</div>
			<div class="d-flex justify-content-between mb-3">
				<p class="fw-semibold">Total</p>
				<p><%= optPed.get().getTotal() %> €</p>
			</div>
			<div class="mb-3">
				<p class="fw-semibold">Productos</p>

				<%
					if (prods != null && !prods.isEmpty()) {
				%>

				<table class="table table-striped table-hover text-center align-middle mt-3 mx-auto mb-5">
					<thead class="table-dark">
					<tr>
						<th>ID</th>
						<th>NOMBRE</th>
						<th>CANTIDAD</th>
						<th>PRECIO</th>
						<th>TOTAL</th>
					</tr>
					</thead>
					<tbody class="table-primary">

						<%
							for (int i = 0; i < prods.size(); i++) {
								Producto prod = prods.get(i);
								int cant = cants.get(i);
								Double total = prod.getPrecio() * cant;
        				%>

						<tr>
							<td><%= prod.getIdProducto() %></td>
							<td class="text-start"><%= prod.getNombre() %></td>
							<td><%= cant %></td>
							<td><%= total %> €</td>
						<tr>

						<%
							}
						%>

					</tbody>
				</table>

				<%
					} else {
				%>

				<p class="fs-5">Este pedido no tiene productos.</p>

				<%
					}
				%>

			</div>
		</div>

		<a class="btn btn-dark w-25 m-auto" href="<%=application.getContextPath()%>/sgames/pedidos">VOLVER</a>

		<% 	} else { %>

		request.sendRedirect("pedidos/");

		<% 	} %>

	</div>

	<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
