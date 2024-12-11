package org.iesbelen.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.iesbelen.dao.DepartamentoDAO;
import org.iesbelen.dao.DepartamentoDAOImpl;
import org.iesbelen.model.Departamento;

@WebServlet(name = "departamentosServlet", value = "/empresa/departamentos/*")
public class DepartamentosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * HTTP Method: GET
     * Paths:
     * 		/departamentos/
     * 		/departamentos/crear
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            DepartamentoDAO depDAO = new DepartamentoDAOImpl();

            //GET
            //	/departamentos/
            //	/departamentos

            String minPres = request.getParameter("min-pres");
            String maxPres = request.getParameter("max-pres");

            List<Departamento> listaDepartamentos = depDAO.getAll();
            // List<DepartamentoDTO> listaDepartamentosDTO = depDAO.getAllDTO();
            // List<DepartamentoDTO> listaDepartamentosDTO = depDAO.getAllDTOFiltered();

            request.setAttribute("listaDepartamentosDTO", listaDepartamentos);
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos/departamentos.jsp");

        } else {
            // GET
            // 		/departamentos/crear
            // 		/departamentos/crear/

            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {

                // GET
                // /departamentos/crear
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos/crear-departamento.jsp");

            } else {
                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos/departamentos.jsp");
            }
        }
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        RequestDispatcher dispatcher;
        String __method__ = request.getParameter("__method__");

        if (__method__ == null) {
            // Crear uno nuevo
            DepartamentoDAO depDAO = new DepartamentoDAOImpl();

            String nombre = request.getParameter("nombre");
            String presupuesto = request.getParameter("presupuesto");
            String gastos = request.getParameter("gastos");

            Departamento nuevoDep = new Departamento();
            nuevoDep.setNombre(nombre);
            nuevoDep.setPresupuesto(Integer.parseInt(presupuesto));
            nuevoDep.setGastos(Integer.parseInt(gastos));

            depDAO.create(nuevoDep);

        } else {
            System.out.println("Opción POST no soportada.");
        }
        response.sendRedirect(request.getContextPath() + "/empresa/departamentos");
    }
}
