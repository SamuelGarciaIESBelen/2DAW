<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@page import="java.util.Optional" %>
<%@ page import="org.sgames.model.Pedido" %>

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

		<% 	Optional<Pedido> optPed = (Optional<Pedido>)request.getAttribute("ped");
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
			<div class="d-flex justify-content-between mb-5">
				<p class="fw-semibold">Fecha</p>
				<p><%= optPed.get().getFecha() %></p>
			</div>
		</div>

		<a class="btn btn-dark w-25 m-auto" href="<%=application.getContextPath()%>/sgames/categorias">VOLVER</a>

		<% 	} else { %>

		request.sendRedirect("categorias/");

		<% 	} %>

	</div>

	<%@ include file="/WEB-INF/jsp/fragmentos/footer.jspf" %>
</body>
</html>
