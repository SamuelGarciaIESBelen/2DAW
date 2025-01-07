package org.sgames.dao;

import org.sgames.model.Pedido;
import org.sgames.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoDAOImpl extends AbstractDAOImpl implements PedidoDAO {

    @Override
    public synchronized void create(Pedido pedido) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO pedido (idPedido, idUsuario, fecha, total) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setInt(idx++, pedido.getIdPedido());
            ps.setInt(idx++, pedido.getIdUsuario());
            ps.setDate(idx++, Date.valueOf(pedido.getFecha()));
            ps.setDouble(idx, pedido.getTotal());

            int rows = ps.executeUpdate();
            if (rows == 0) { System.out.println("INSERT de pedido con 0 filas insertadas."); }

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next()) {
                pedido.setIdPedido(rsGenKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Pedido> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Pedido> peds = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM pedido");
            while (rs.next()) {
                Pedido ped = new Pedido();
                int idx = 1;

                ped.setIdPedido(rs.getInt(idx++));
                ped.setIdUsuario(rs.getInt(idx++));
                ped.setFecha(rs.getDate(idx++).toLocalDate());
                ped.setTotal(rs.getDouble(idx));

                peds.add(ped);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return peds;
    }

    @Override
    public Optional<Pedido> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM pedido WHERE idPedido = ?");

            int idx =  1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Pedido ped = new Pedido();
                idx = 1;

                ped.setIdPedido(rs.getInt(idx++));
                ped.setIdUsuario(rs.getInt(idx++));
                ped.setFecha(rs.getDate(idx++).toLocalDate());
                ped.setTotal(rs.getDouble(idx));

                return Optional.of(ped);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
        return Optional.empty();
    }

    @Override
    public void update(Pedido pedido) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE pedido SET idUsuario = ?, fecha = ?, total = ? WHERE idPedido = ?");

            int idx = 1;

            ps.setInt(idx++, pedido.getIdUsuario());
            ps.setDate(idx++, Date.valueOf(pedido.getFecha()));
            ps.setDouble(idx++, pedido.getTotal());
            ps.setInt(idx, pedido.getIdPedido());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("Update de pedido con 0 registros actualizados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = null;
        PreparedStatement ps = null; // Pedido
        PreparedStatement psProductos = null; // Productos

        try {
            conn = connectDB();

            // Productos
            psProductos = conn.prepareStatement("DELETE FROM productos_pedido WHERE idPedido = ?");

            int idx = 1;
            psProductos.setInt(idx, id);

            int rows = psProductos.executeUpdate();
            if (rows == 0) {
                System.out.println("Delete de productos con 0 registros eliminados.");
            }

            // Pedido
            ps = conn.prepareStatement("DELETE FROM pedido WHERE idPedido = ?");

            idx = 1;
            ps.setInt(idx, id);

            rows = ps.executeUpdate();
            if (rows == 0) {
                System.out.println("Delete de pedido con 0 registros eliminados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, psProductos, null);
            closeDb(conn, ps, null);
        }
    }

    @Override
    public void createConProductos(Pedido pedido, List<Producto> productos, List<Integer> cantidades) {
        create(pedido);

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("INSERT INTO productos_pedido (idPedido, idProducto, cantidad) VALUES (?, ?, ?)");

            int idx = 1;
            for (int i = 0; i < productos.size(); i++) {
                idx = 1;

                ps.setInt(idx++, pedido.getIdPedido());
                ps.setInt(idx++, productos.get(i).getIdProducto());
                ps.setInt(idx, cantidades.get(i));

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Pedido> getPedidosByCliente(int idCliente) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pedido> peds = new ArrayList<>();

        try {
            conn = connectDB();
            ps = conn.prepareStatement("SELECT * FROM pedido WHERE idCliente = ?");

            int idx = 1;
            ps.setInt(idx, idCliente);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pedido ped = new Pedido();
                idx = 1;

                ped.setIdPedido(rs.getInt(idx++));
                ped.setIdUsuario(rs.getInt(idx++));
                ped.setFecha(rs.getDate(idx++).toLocalDate());
                ped.setTotal(rs.getDouble(idx));

                peds.add(ped);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
        return peds;
    }

    @Override
    public List<Producto> getProductos(int idPedido) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Producto> prods = new ArrayList<>();

        try {
            conn = connectDB();
            ps = conn.prepareStatement("SELECT p.idProducto, p.nombre, p.descripcion, p.precio, p.idCategoria" +
                            "FROM productos_pedido pp JOIN producto p USING (idProducto) WHERE pp.idPedido = ?");

            int idx = 1;
            ps.setInt(idx, idPedido);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto pr = new Producto();
                idx = 1;

                pr.setIdProducto(rs.getInt(idx++));
                pr.setNombre(rs.getString(idx++));
                pr.setDescripcion(rs.getString(idx++));
                pr.setPrecio(rs.getDouble(idx++));
                pr.setIdCategoria(rs.getInt(idx));

                prods.add(pr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
        return prods;
    }

    @Override
    public List<Integer> getCantidades(int idPedido) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Integer> cants = new ArrayList<>();

        try {
            conn = connectDB();
            ps = conn.prepareStatement("SELECT cantidad FROM productos_pedido WHERE idPedido = ?");

            int idx = 1;
            ps.setInt(idx, idPedido);
            rs = ps.executeQuery();

            while (rs.next()) {
                idx = 1;
                cants.add(rs.getInt(idx));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
        return cants;
    }
}
