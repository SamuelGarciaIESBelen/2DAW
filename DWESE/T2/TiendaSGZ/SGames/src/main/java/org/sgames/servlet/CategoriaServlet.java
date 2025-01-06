package org.sgames.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sgames.dao.CategoriaDAO;
import org.sgames.dao.CategoriaDAOImpl;
import org.sgames.model.Categoria;
import org.sgames.model.CategoriaDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "categoriaServlet", value = "/sgames/categorias/*")
public class CategoriaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * HTTP Method: GET
	 * Paths: 
	 * 		/categorias/
	 * 		/categorias/{id}
	 * 		/categorias/editar{id}
	 * 		/categorias/crear
	 */		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
				
		String pathInfo = request.getPathInfo(); //
			
		if (pathInfo == null || "/".equals(pathInfo)) {
			CategoriaDAO catDAO = new CategoriaDAOImpl();
			
			// GET
			//	/categorias/
			//	/categorias

			List<CategoriaDTO> catsDTO = catDAO.getAllDTO();

			request.setAttribute("catsDTO", catsDTO);
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/categorias.jsp");

		} else {
			// GET
			// 		/categorias/{id}
			// 		/categorias/{id}/
			// 		/categorias/edit/{id}
			// 		/categorias/edit/{id}/
			// 		/categorias/crear
			// 		/categorias/crear/
			
			pathInfo = pathInfo.replaceAll("/$", "");
			String[] pathParts = pathInfo.split("/");
			
			if (pathParts.length == 2 && "crear".equals(pathParts[1])) {
				
				// GET
				// /categorias/crear
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/crear-categoria.jsp");

			} else if (pathParts.length == 2) {
				CategoriaDAO catDAO = new CategoriaDAOImpl();
				// GET
				// /categorias/{id}
				try {
					int id = Integer.parseInt(pathParts[1]);
					Optional<Categoria> cat = catDAO.find(id);
					Optional<CategoriaDTO> catDTO = cat.map(c -> new CategoriaDTO(c, catDAO.getCountProductos(id).orElse(0)));

					request.setAttribute("cat", catDTO);
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/detalle-categoria.jsp");

				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/categorias.jsp");
				}
			} else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
				CategoriaDAO catDAO = new CategoriaDAOImpl();
				
				// GET
				// /catehorias/editar/{id}
				try {
					request.setAttribute("cat",catDAO.find(Integer.parseInt(pathParts[2])));
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/editar-categoria.jsp");
					        								
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/categorias.jsp");
				}
			} else {
				System.out.println("Opción POST no soportada.");
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/categoria/categorias.jsp");
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
			CategoriaDAO catDAO = new CategoriaDAOImpl();
			
			String nombre = request.getParameter("nombre");
			Categoria nuevaCat = new Categoria();
			nuevaCat.setNombre(nombre);
			catDAO.create(nuevaCat);
			
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
		response.sendRedirect(request.getContextPath() + "/sgames/categorias");
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoriaDAO catDAO = new CategoriaDAOImpl();
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		Categoria cat = new Categoria();
		
		try {
			int id = Integer.parseInt(codigo);
			cat.setIdCategoria(id);
			cat.setNombre(nombre);
			catDAO.update(cat);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	{
		RequestDispatcher dispatcher;
		CategoriaDAO catDAO = new CategoriaDAOImpl();
		String codigo = request.getParameter("codigo");
		
		try {
			int id = Integer.parseInt(codigo);
			catDAO.delete(id);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}
}
