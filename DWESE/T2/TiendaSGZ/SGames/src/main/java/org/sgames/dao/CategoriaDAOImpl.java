package org.sgames.dao;

import org.sgames.model.Categoria;
import org.sgames.model.CategoriaDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaDAOImpl extends AbstractDAOImpl implements CategoriaDAO {

	@Override	
	public synchronized void create(Categoria categoria) {
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
        	conn = connectDB();

        	ps = conn.prepareStatement("INSERT INTO categoria (nombre) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setString(idx, categoria.getNombre());

            int rows = ps.executeUpdate();
            if (rows == 0) {
				System.out.println("INSERT de categoria con 0 filas insertadas.");
			}

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next()) {
				categoria.setIdCategoria(rsGenKeys.getInt(1));
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
	public List<Categoria> getAll() {
		Connection conn = null;
		Statement s = null;
        ResultSet rs = null;
        
        List<Categoria> cats = new ArrayList<>();
        
        try {
        	conn = connectDB();

        	s = conn.createStatement();
            		
        	rs = s.executeQuery("SELECT * FROM categoria");
            while (rs.next()) {
            	Categoria cat = new Categoria();
            	int idx = 1;

				cat.setIdCategoria(rs.getInt(idx++));
            	cat.setNombre(rs.getString(idx));

				cats.add(cat);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, s, rs);
        }
        return cats;
	}

	@Override
	public Optional<Categoria> find(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	ps = conn.prepareStatement("SELECT * FROM categoria WHERE idCategoria = ?");
        	
        	int idx =  1;
        	ps.setInt(idx, id);
        	
        	rs = ps.executeQuery();
        	
        	if (rs.next()) {
        		Categoria cat = new Categoria();
        		idx = 1;

				cat.setIdCategoria(rs.getInt(idx++));
        		cat.setNombre(rs.getString(idx));
        		
        		return Optional.of(cat);
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
	public void update(Categoria categoria) {
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	ps = conn.prepareStatement("UPDATE categoria SET nombre = ?  WHERE idCategoria = ?");
        	int idx = 1;
        	ps.setString(idx++, categoria.getNombre());
        	ps.setInt(idx, categoria.getIdCategoria());
        	
        	int rows = ps.executeUpdate();
        	
        	if (rows == 0) {
				System.out.println("Update de categoria con 0 registros actualizados.");
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
        	
        	ps = conn.prepareStatement("DELETE FROM categoria WHERE idCategoria = ?");
        	int idx = 1;
        	ps.setInt(idx, id);
        	
        	int rows = ps.executeUpdate();
        	
        	if (rows == 0) {
				System.out.println("Delete de categoria con 0 registros eliminados.");
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
	public Optional<Integer> getCountProductos(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Optional<Integer> numProductos = Optional.empty();

		try {
			conn = connectDB();
			ps = conn.prepareStatement("SELECT COUNT(*) FROM producto WHERE idCategoria = ?");

			int idx = 1;
			ps.setInt(idx, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				// idx = 1;
				numProductos = Optional.of(rs.getInt(idx));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeDb(conn, ps, rs);
		}
		return numProductos;
    }

	@Override
	public List<CategoriaDTO> getAllDTO() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CategoriaDTO> cats = new ArrayList<>();

		try {
			conn = connectDB();

			String query =	"select c.idCategoria, c.nombre, count(idProducto) " +
							"from categoria c left join producto p using (idCategoria) " +
							"group by idCategoria";

			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			int idx;

			while (rs.next()) {
				idx = 1;

				int idCat = rs.getInt(idx++);
				String nombre = rs.getString(idx++);
				int countProd = rs.getInt(idx);

				cats.add(new CategoriaDTO(idCat, nombre, countProd));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeDb(conn, ps, rs);
		}
		return cats;
	}
}