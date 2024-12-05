package org.iesbelen.dao;

import org.iesbelen.model.Departamento;
import org.iesbelen.model.DepartamentoDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class DepartamentoDAOImpl extends AbstractDAOImpl implements DepartamentoDAO {
    @Override
    public void create(Departamento departamento) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("INSERT INTO departamento (nombre, presupuesto, gastos) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setString(idx++, departamento.getNombre());
            ps.setInt(idx++, departamento.getPresupuesto());
            ps.setInt(idx, departamento.getGastos());

            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de Departamento con 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                departamento.setCodigo(rsGenKeys.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public List<Departamento> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Departamento> listDep = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM departamento");
            while (rs.next()) {
                Departamento dep = new Departamento();
                int idx = 1;
                dep.setCodigo(rs.getInt(idx++));
                dep.setNombre(rs.getString(idx++));
                dep.setPresupuesto(rs.getInt(idx++));
                dep.setGastos(rs.getInt(idx));
                listDep.add(dep);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listDep;
    }

    @Override
    public Optional<Departamento> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM departamento WHERE codigo = ?");

            int idx =  1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Departamento dep = new Departamento();
                idx = 1;
                dep.setCodigo(rs.getInt(idx++));
                dep.setNombre(rs.getString(idx++));
                dep.setPresupuesto(rs.getInt(idx++));
                dep.setGastos(rs.getInt(idx));

                return Optional.of(dep);
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
    public List<DepartamentoDTO> getAllDTO() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DepartamentoDTO> listDep = new ArrayList<>();

        try {
            conn = connectDB();

            String query = "SELECT d.codigo, d.nombre, d.presupuesto, d.gastos, count(e.codigo) " +
                    "FROM departamento d left join empleados e on d.codigo = e.codigo_departamento " +
                    "GROUP BY d.codigo";

            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            int idx;

            while (rs.next()) {
                idx = 1;
                int codigo = rs.getInt(idx++);
                String nombre = rs.getString(idx++);
                int presupuesto = rs.getInt(idx++);
                int gastos = rs.getInt(idx++);
                int numEmp = rs.getInt(idx);

                listDep.add(new DepartamentoDTO(codigo, nombre, presupuesto, gastos, numEmp));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
        return listDep;
    }

    @Override
    public List<Departamento> getAllFiltered(int min,int max) {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Departamento> listDep = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM departamento where (presupuesto - gastos) > ? && (presupuesto - gastos) < ?");

            while (rs.next()) {
                Departamento dep = new Departamento();
                int idx = 1;
                dep.setCodigo(rs.getInt(idx++));
                dep.setNombre(rs.getString(idx++));
                dep.setPresupuesto(rs.getInt(idx++));
                dep.setGastos(rs.getInt(idx));
                listDep.add(dep);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listDep;
    }
}
