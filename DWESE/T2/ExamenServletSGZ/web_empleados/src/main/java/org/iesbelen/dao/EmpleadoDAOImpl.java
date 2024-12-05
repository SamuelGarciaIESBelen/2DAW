package org.iesbelen.dao;

import org.iesbelen.model.Departamento;
import org.iesbelen.model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpleadoDAOImpl extends AbstractDAOImpl implements EmpleadoDAO {
    @Override
    public List<Empleado> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Empleado> listEmp = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM empleado");
            while (rs.next()) {
                Empleado emp = new Empleado();
                int idx = 1;
                emp.setCodigo(rs.getInt(idx++));
                emp.setNif(rs.getString(idx++));
                emp.setNombre(rs.getString(idx++));
                emp.setApellido1(rs.getString(idx++));
                emp.setApellido2(rs.getString(idx++));
                emp.setCodigoDep(rs.getInt(idx));
                listEmp.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listEmp;
    }

    @Override
    public Optional<Empleado> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM empleado WHERE codigo = ?");

            int idx =  1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Empleado emp = new Empleado();
                idx = 1;
                emp.setCodigo(rs.getInt(idx++));
                emp.setNif(rs.getString(idx++));
                emp.setNombre(rs.getString(idx++));
                emp.setApellido1(rs.getString(idx++));
                emp.setApellido2(rs.getString(idx++));
                emp.setCodigoDep(rs.getInt(idx));

                return Optional.of(emp);
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
    public void update(Empleado empleado) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE empleado SET nif = ?, nombre = ?, apellido1 = ?, apellido2 = ?, codigo_departamento = ? WHERE codigo = ?");
            int idx = 1;
            ps.setString(idx++, empleado.getNif());
            ps.setString(idx++, empleado.getNombre());
            ps.setString(idx++, empleado.getApellido1());
            ps.setString(idx++, empleado.getApellido2());
            ps.setInt(idx++, empleado.getCodigoDep());
            ps.setInt(idx, empleado.getCodigo());

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Update de Empleado con 0 registros actualizados.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }
}
