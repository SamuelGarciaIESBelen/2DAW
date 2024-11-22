package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.iesbelen.model.Usuario;
import org.iesbelen.dao.UsuarioDAO;
import org.iesbelen.dao.UsuarioDAOImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "usuariosServlet", value = "/tienda/usuarios/*")
public class UsuariosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * HTTP Method: GET
     * Paths:
     * 		/usuarios/
     * 		/usuarios/{id}
     * 		/usuarios/editar{id}
     * 		/usuarios/crear
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

            //GET
            //	/usuarios/
            //	/usuarios

            List<Usuario> listaUsuarios = usuarioDAO.getAll();

            request.setAttribute("listaUsuarios", listaUsuarios);
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");

        } else {
            // GET
            // 		/usuarios/{id}
            // 		/usuarios/{id}/
            // 		/usuarios/edit/{id}
            // 		/usuarios/edit/{id}/
            // 		/usuarios/crear
            // 		/usuarios/crear/

            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {

                // GET
                // /usuarios/crear

                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/crear-usuario.jsp");


            } else if (pathParts.length == 2) {
                UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

                // GET
                // /usuarios/{id}

                try {
                    request.setAttribute("usuario",usuarioDAO.find(Integer.parseInt(pathParts[1])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/detalle-usuario.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");
                }

            } else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
                UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

                // GET
                // /usuarios/editar/{id}

                try {
                    request.setAttribute("usuario",usuarioDAO.find(Integer.parseInt(pathParts[2])));
                    request.setAttribute("listaUsuarios", usuarioDAO.getAll());
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/editar-usuario.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");
                }


            } else {

                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuarios.jsp");

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
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

            String nombre = request.getParameter("nombre");
            String password = request.getParameter("password");
            String rol = request.getParameter("rol");

            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setPassword(password);
            nuevoUsuario.setRol(rol);

            usuarioDAO.create(nuevoUsuario);

        } else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
            // Actualizar uno existente
            // Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
            doPut(request, response);

        } else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {
            // Actualizar uno existente
            // Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización DELETE.
            doDelete(request, response);

        } else {
            System.out.println("Opción POST no soportada.");
        }

        //response.sendRedirect("../../../tienda/usuarios");
        response.sendRedirect(request.getContextPath() + "/tienda/usuarios");
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");

        Usuario usuario = new Usuario();

        try {

            int id = Integer.parseInt(codigo);
            usuario.setIdUsuario(id);
            usuario.setNombre(nombre);
            usuario.setPassword(password);
            usuario.setRol(rol);

            usuarioDAO.update(usuario);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
    {
        RequestDispatcher dispatcher;
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        String codigo = request.getParameter("codigo");

        try {

            int id = Integer.parseInt(codigo);

            usuarioDAO.delete(id);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }
}
