package org.sgames.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.sgames.dao.ProductoDAO;
import org.sgames.dao.ProductoDAOImpl;
import org.sgames.dao.PedidoDAO;
import org.sgames.dao.PedidoDAOImpl;
import org.sgames.model.Producto;
import org.sgames.model.Pedido;
import org.sgames.model.Usuario;

@WebServlet(name = "carritoServlet", value = "/sgames/carrito")
public class CarritoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductoDAO prodDAO = new ProductoDAOImpl();
    private PedidoDAO pedDAO = new PedidoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        Map<Integer, Integer> carrito = (Map<Integer, Integer>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new HashMap<>();
        }

        List<Producto> todosProd = prodDAO.getAll();
        Map<Integer, Integer> finalCarrito = carrito;

        List<Producto> prods = todosProd.stream()
                .filter(p -> finalCarrito.containsKey(p.getIdProducto()))
                .collect(Collectors.toList());

        double total = 0;
        for (Producto prod : prods) {
            double precioCantidad = prod.getPrecio() * carrito.get(prod.getIdProducto());
            total = total + precioCantidad;
        }

        request.setAttribute("prodsCarrito", prods);
        request.setAttribute("carritoMap", carrito);
        request.setAttribute("total", total);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuario/carrito.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        Map<Integer, Integer> carrito = (Map<Integer, Integer>) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new HashMap<>();
        }

        String __method__ = request.getParameter("__method__");

        if (__method__ == null || "confirmar".equalsIgnoreCase(__method__)) {
            if (carrito.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/sgames/carrito");
                return;
            }

            Usuario userlog = (Usuario) session.getAttribute("usuario");
            if (userlog == null) {
                response.sendRedirect(request.getContextPath() + "/sgames/usuarios/login");
                return;
            }

            List<Producto> todosProd = prodDAO.getAll();
            Map<Integer, Integer> finalCarrito = carrito;

            List<Producto> prods = todosProd.stream()
                    .filter(p -> finalCarrito.containsKey(p.getIdProducto()))
                    .collect(Collectors.toList());

            double total = 0;
            List<Integer> cants = new ArrayList<>();

            for (Producto prod : prods) {
                int cant = carrito.get(prod.getIdProducto());
                double subtotal = prod.getPrecio() * cant;
                total = total + subtotal;
                cants.add(cant);
            }

            Pedido p = new Pedido();
            p.setIdUsuario(userlog.getIdUsuario());
            p.setFecha(LocalDate.now());
            p.setTotal(total);

            pedDAO.createConProductos(p, prods, cants);

            carrito.clear();
        } else if ("put".equalsIgnoreCase(__method__)) {
            doPut(request, response);
        } else if ("delete".equalsIgnoreCase(__method__)) {
            doDelete(request, response);
        }
        session.setAttribute("carrito", carrito);
        response.sendRedirect(request.getContextPath() + "/sgames/carrito");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        Map<Integer, Integer> carrito = (Map<Integer, Integer>) session.getAttribute("carrito");

        int idProd = Integer.parseInt(request.getParameter("idProd"));
        int nuevaCantidad = Integer.parseInt(request.getParameter("cantidad"));

        carrito.put(idProd, nuevaCantidad);

        session.setAttribute("carrito", carrito);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        Map<Integer, Integer> carrito = (Map<Integer, Integer>) session.getAttribute("carrito");

        int idProd = Integer.parseInt(request.getParameter("idProd"));
        carrito.remove(idProd);

        session.setAttribute("carrito", carrito);
    }
}
