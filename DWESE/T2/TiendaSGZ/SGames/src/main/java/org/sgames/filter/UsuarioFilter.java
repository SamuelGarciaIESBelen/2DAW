package org.sgames.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.sgames.model.Usuario;

import java.io.IOException;

@WebFilter(
        urlPatterns = { "/sgames/usuarios/*" },
        initParams = {
                @WebInitParam(name = "acceso-concedido-a-rol", value = "Admin")
        })
public class UsuarioFilter extends HttpFilter implements Filter {

    private String rolAcceso;

    /**
     * @see HttpFilter#HttpFilter()
     */
    public UsuarioFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Cast de ServletRequest a HttpServletRequest, el único tipo implementado
        // en el contenedor de Servlet: HttpServletRequest & HttpServletResponse
        HttpServletRequest httpRequest =(HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;


        // Accediendo al objeto de sesión
        HttpSession session = httpRequest.getSession();

        // Obteniendo la url
        String url = httpRequest.getRequestURL().toString();

        Usuario usuario = null;

        if (session != null  // Seteo inline de usuario
                && (usuario = (Usuario)session.getAttribute("user-login")) != null
                && rolAcceso.equals(usuario.getRol())) {

            // Si eres administrador acceso a cualquier página del filtro
            chain.doFilter(request, response);
            return;

        } else if (url.endsWith("/usuarios")
                || url.endsWith("/usuarios/crear")
                || url.contains("/usuarios/editar")
                || url.contains("/usuarios/borrar")) {

            // Usuario no administrador trata de acceder a páginas de crear y editar, y el filtro lo redirige a login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/sgames/usuarios/login");
            return;

        } else {
            // Otras rutas /usuarios y /usuarios/{id} se dan paso a cualquier rol

            // RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp");
            // dispatcher.forward(httpRequest, httpResponse);
            chain.doFilter(request, response);
            return;
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        this.rolAcceso = fConfig.getInitParameter("acceso-concedido-a-rol");
    }
}