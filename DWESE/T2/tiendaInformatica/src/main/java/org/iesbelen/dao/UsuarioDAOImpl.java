package org.iesbelen.dao;

import org.iesbelen.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAOImpl extends AbstractDAOImpl implements UsuarioDAO{

    @Override
    public synchronized void create(Usuario usuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();


            //1 alternativas comentadas:
            //ps = conn.prepareStatement("INSERT INTO usuarios (nombre) VALUES (?)", new String[] {"codigo"});
            //Ver también, AbstractDAOImpl.executeInsert ...
            //Columna fabricante.codigo es clave primaria auto_increment, por ese motivo se omite de la sentencia SQL INSERT siguiente.
            ps = conn.prepareStatement("INSERT INTO usuarios (nombre, password, rol) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setString(idx++, usuario.getNombre());
            ps.setString(idx++, usuario.getPassword());
            ps.setString(idx, usuario.getRol());

            int rows = ps.executeUpdate();
            if (rows == 0) { System.out.println("INSERT de usuarios con 0 filas insertadas."); }

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                usuario.setIdUsuario(rsGenKeys.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Usuario> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Usuario> listUsers = new ArrayList<>();

        try {
            conn = connectDB();

            // Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                Usuario user = new Usuario();
                int idx = 1;

                user.setIdUsuario(rs.getInt(idx++));
                user.setNombre(rs.getString(idx++));
                user.setPassword(rs.getString(idx++));
                user.setRol(rs.getString(idx));

                listUsers.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listUsers;
    }

    @Override
    public Optional<Usuario> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM usuarios WHERE idUsuario = ?");

            int idx =  1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Usuario user = new Usuario();
                idx = 1;

                user.setIdUsuario(rs.getInt(idx++));
                user.setNombre(rs.getString(idx++));
                user.setPassword(rs.getString(idx++));
                user.setRol(rs.getString(idx));

                return Optional.of(user);
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
    public void update(Usuario usuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE usuarios SET nombre = ?, password = ?, rol = ?  WHERE idUsuario = ?");

            int idx = 1;

            ps.setString(idx++, usuario.getNombre());
            ps.setString(idx++, usuario.getPassword());
            ps.setString(idx++, usuario.getRol());
            ps.setInt(idx, usuario.getIdUsuario());

            int rows = ps.executeUpdate();

            if (rows == 0) { System.out.println("Update de usuarios con 0 registros actualizados."); }

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

            ps = conn.prepareStatement("DELETE FROM usuarios WHERE idUsuario = ?");
            int idx = 1;
            ps.setInt(idx, id);

            int rows = ps.executeUpdate();

            if (rows == 0) { System.out.println("Delete de usuarios con 0 registros eliminados."); }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public Optional<Usuario> findName(String nombre) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM usuarios WHERE nombre = ?");

            int idx =  1;
            ps.setString(idx, nombre);

            rs = ps.executeQuery();

            if (rs.next()) {
                Usuario user = new Usuario();
                idx = 1;

                user.setIdUsuario(rs.getInt(idx++));
                user.setNombre(rs.getString(idx++));
                user.setPassword(rs.getString(idx++));
                user.setRol(rs.getString(idx));

                return Optional.of(user);
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


}
