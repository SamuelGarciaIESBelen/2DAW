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
        urlPatterns = { "/sgames/*" },
        initParams = {
                @WebInitParam(name = "acceso-concedido-a-rol", value = "Admin")
        })
public class AdminFilter extends HttpFilter implements Filter {

    private String rolAcceso;

    /**
     * @see HttpFilter#HttpFilter()
     */
    public AdminFilter() {
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
        // en el contenedor de Servlet: HttpServletRequest & HttpServletReponse
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

        } else if (url.endsWith("/carrito")
                || url.endsWith("/categorias/crear")
                || url.contains("/categorias/editar")
                || url.contains("/categorias/borrar")
                || url.endsWith("/productos/crear")
                || url.contains("/productos/editar")
                || url.contains("/productos/borrar")
                || url.endsWith("/pedidos/crear")
                || url.contains("/pedidos/editar")
                || url.contains("/pedidos/borrar")
                || url.endsWith("/usuarios")
                || url.contains("/usuarios/editar")
                || url.contains("/usuarios/borrar")) {

            // Usuario no administrador trata de acceder a páginas de crear y editar, y el filtro lo redirige a login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/sgames/usuarios/login");
            return;

        } else {

            // Otras rutas /categorias y /productos se dan paso a cualquier rol

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