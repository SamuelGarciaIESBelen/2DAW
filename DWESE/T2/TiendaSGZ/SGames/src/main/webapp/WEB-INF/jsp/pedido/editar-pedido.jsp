<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@page import="org.sgames.model.Pedido" %>
<%@page import="java.util.Optional" %>
<%@ page import="java.time.LocalDate" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Editar Pedido</title>
	<%@ include file="/WEB-INF/jsp/fragmentos/bootstrap.jspf" %>
</head>
<body class="bg-light">
	<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>

	<div class="container p-5 d-flex flex-column">
		<h2 class="text-center">EDITAR PEDIDO</h2>

		<% 	Optional<Pedido> optPed = (Optional<Pedido>)request.getAttribute("ped");
			if (optPed.isPresent()) {
		%>

		<form class="form my-5 mx-auto w-25" action="${pageContext.request.contextPath}/sgames/pedidos/editar/" method="post">
			<input type="hidden" name="__method__" value="put" />
			<div class="d-flex justify-content-between mb-5">
				<label class="my-auto fs-5 fw-semibold">ID</label>
				<input class="form-control ms-3 w-25" type="text" name="codigo" value="<%= optPed.get().getIdPedido() %>" readonly>
			</div>
			<div class="d-flex justify-content-between mb-5">
				<label class="my-auto fs-5 fw-semibold">ID Usuario</label>
				<input class="form-control ms-3 w-25" type="number" name="idUsuario" min="1" value="<%= optPed.get().getIdUsuario() %>">
			</div>
			<div class="d-flex justify-content-between mb-5">
				<label class="my-auto fs-5 fw-semibold">Fecha</label>
				<input class="form-control ms-3 w-50" type="date" value="<%= optPed.get().getFecha() %>" name="fecha">
			</div>
			<div class="d-flex justify-content-between mb-5">
				<label class="my-auto fs-5 fw-semibold">Total</label>
				<input class="form-control ms-3 w-50" type="number" name="total" step="0.01" min="0.01" placeholder="€" value="<%= optPed.get().getTotal() %>" required>
			</div>
			<div class="m-auto text-center">
				<button class="btn btn-dark">
					<a class="text-light link-underline link-underline-opacity-0" href="<%=application.getContextPath()%>/sgames/pedidos">VOLVER</a>
				</button>
				<input class="btn btn-primary ms-3" type="submit" value="EDITAR">
			</div>
		</form>
	</div>

	<% 	} else { %>

	request.sendRedirect("pedidos/");

	<% 	} %>

	<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
