package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.iesbelen.dao.DepartamentoDAOImpl;
import org.iesbelen.dao.EmpleadoDAO;
import org.iesbelen.dao.EmpleadoDAOImpl;
import org.iesbelen.model.Empleado;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "empleadosServlet", value = "/empresa/empleados/*")
public class EmpleadosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * HTTP Method: GET
     * Paths:
     * 		/empleados/
     * 		/empleados/editar{id}
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            EmpleadoDAO empDAO = new EmpleadoDAOImpl();

            //GET
            //	/empleados/
            //	/empleados

            request.setAttribute("listaEmpleados", empDAO.getAll());
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/empleados.jsp");

        } else {
            // GET
            // 		/empleados/edit/{id}
            // 		/empleados/edit/{id}/

            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
                EmpleadoDAO empDAO = new EmpleadoDAOImpl();
                DepartamentoDAOImpl depDAO = new DepartamentoDAOImpl();

                // GET
                // /empleados/editar/{id}

                try {
                    request.setAttribute("empleado",empDAO.find(Integer.parseInt(pathParts[2])));
                    request.setAttribute("listaDepartamentos", depDAO.getAll());
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/editar-empleado.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/empleados.jsp");
                }
            } else {
                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados/empleados.jsp");
            }
        }
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        RequestDispatcher dispatcher;
        String __method__ = request.getParameter("__method__");

        if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
            // Actualizar uno existente
            //Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
            doPut(request, response);

        } else {
            System.out.println("Opción POST no soportada.");
        }

        response.sendRedirect(request.getContextPath() + "/empresa/empleados");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

        EmpleadoDAO empDAO = new EmpleadoDAOImpl();
        String codigo = request.getParameter("codigo");
        String nif = request.getParameter("nif");
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String codDep = request.getParameter("codDep");

        Empleado emp = new Empleado();

        try {
            emp.setCodigo(Integer.parseInt(codigo));
            emp.setNif(nif);
            emp.setNombre(nombre);
            emp.setApellido1(apellido1);
            emp.setApellido2(apellido2);
            emp.setCodigoDep(Integer.parseInt(codDep));

            empDAO.update(emp);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }
}
