package org.sgames.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sgames.dao.PedidoDAO;
import org.sgames.dao.PedidoDAOImpl;
import org.sgames.model.Pedido;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "pedidoServlet", value = "/sgames/pedidos/*")
public class PedidoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * HTTP Method: GET
	 * Paths: 
	 * 		/pedidos/
	 * 		/pedidos/{id}
	 * 		/pedidos/editar{id}
	 * 		/pedidos/crear
	 */		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
				
		String pathInfo = request.getPathInfo(); //
			
		if (pathInfo == null || "/".equals(pathInfo)) {
			PedidoDAO pedDAO = new PedidoDAOImpl();
			
			// GET
			//	/pedidos/
			//	/pedidos

			List<Pedido> peds = pedDAO.getAll();

			request.setAttribute("peds", peds);
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedido/pedidos.jsp");

		} else {
			// GET
			// 		/pedidos/{id}
			// 		/pedidos/{id}/
			// 		/pedidos/edit/{id}
			// 		/pedidos/edit/{id}/
			// 		/pedidos/crear
			// 		/pedidos/crear/
			
			pathInfo = pathInfo.replaceAll("/$", "");
			String[] pathParts = pathInfo.split("/");
			
			if (pathParts.length == 2 && "crear".equals(pathParts[1])) {
				
				// GET
				// /pedidos/crear
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedido/crear-pedido.jsp");

			} else if (pathParts.length == 2) {
				PedidoDAO pedDAO = new PedidoDAOImpl();
				// GET
				// /pedidos/{id}
				try {
					int id = Integer.parseInt(pathParts[1]);
					Optional<Pedido> ped = pedDAO.find(id);

					request.setAttribute("ped", ped);
					request.setAttribute("prods", pedDAO.getProductos(id));
					request.setAttribute("cants", pedDAO.getCantidades(id));
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedido/detalle-pedido.jsp");

				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedido/pedidos.jsp");
				}
			} else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
				PedidoDAO pedDAO = new PedidoDAOImpl();
				// GET
				// /pedidos/editar/{id}
				try {
					request.setAttribute("ped",pedDAO.find(Integer.parseInt(pathParts[2])));
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedido/editar-pedido.jsp");

				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedido/pedidos.jsp");
				}
			} else {
				System.out.println("Opción POST no soportada.");
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedido/pedidos.jsp");
			}
		}
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		String __method__ = request.getParameter("__method__");
		
		if (__method__ == null) {
			// Crear uno nuevo
			PedidoDAO pedDAO = new PedidoDAOImpl();
			
			String idUsuario = request.getParameter("idUsuario");
			String fecha = request.getParameter("fecha");
			String total = request.getParameter("total");

			Pedido nuevoPed = new Pedido();
			nuevoPed.setIdUsuario(Integer.parseInt(idUsuario));
			nuevoPed.setFecha(LocalDate.parse(fecha));
			nuevoPed.setTotal(Double.parseDouble(total));
			pedDAO.create(nuevoPed);
			
		} else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {			
			// Actualizar uno existente
			// Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
			doPut(request, response);

		} else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {			
			// Borrar uno existente
			// Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización DELETE.
			doDelete(request, response);
		} else {
			System.out.println("Opción POST no soportada.");
		}
		response.sendRedirect(request.getContextPath() + "/sgames/pedidos");
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PedidoDAO pedDAO = new PedidoDAOImpl();
		String codigo = request.getParameter("codigo");
		String idUsuario = request.getParameter("idUsuario");
		String fecha = request.getParameter("fecha");
		String total = request.getParameter("total");
		Pedido ped = new Pedido();

		try {
			ped.setIdPedido(Integer.parseInt(codigo));
			ped.setIdUsuario(Integer.parseInt(idUsuario));
			ped.setFecha(LocalDate.parse(fecha));
			ped.setTotal(Double.parseDouble(total));
			pedDAO.update(ped);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	{
		RequestDispatcher dispatcher;
		PedidoDAO pedDAO = new PedidoDAOImpl();
		String codigo = request.getParameter("codigo");
		
		try {
			int id = Integer.parseInt(codigo);
			pedDAO.delete(id);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}
}
