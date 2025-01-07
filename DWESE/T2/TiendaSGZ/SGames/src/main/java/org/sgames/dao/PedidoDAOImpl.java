package org.sgames.dao;

import org.sgames.model.Pedido;

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

            ps = conn.prepareStatement("INSERT INTO pedido (idPedido, idUsuario, fecha) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setInt(idx++, pedido.getIdPedido());
            ps.setInt(idx++, pedido.getIdUsuario());
            ps.setString(idx, pedido.getFecha());

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
                ped.setFecha(rs.getString(idx));

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
                ped.setFecha(rs.getString(idx));

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

            ps = conn.prepareStatement("UPDATE pedido SET idCliente = ?, fecha = ? WHERE idPedido = ?");

            int idx = 1;

            ps.setInt(idx++, pedido.getIdUsuario());
            ps.setString(idx++, pedido.getFecha());
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
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("DELETE FROM pedido WHERE idPedido = ?");
            int idx = 1;
            ps.setInt(idx, id);

            int rows = ps.executeUpdate();

            if (rows == 0) { System.out.println("Delete de pedido con 0 registros eliminados."); }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Pedido> filterByUser(int idUsuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pedido> peds = new ArrayList<>();

        try {
            conn = connectDB();

            String query = "SELECT * FROM producto WHERE idUsuario = ?";

            int idx = 1;

            ps = conn.prepareStatement(query);
            ps.setInt(idx, idUsuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pedido ped = new Pedido();
                idx = 1;

                ped.setIdPedido(rs.getInt(idx++));
                ped.setIdUsuario(rs.getInt(idx++));
                ped.setFecha(rs.getString(idx));

                peds.add(ped);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
        return peds;
    }
}
