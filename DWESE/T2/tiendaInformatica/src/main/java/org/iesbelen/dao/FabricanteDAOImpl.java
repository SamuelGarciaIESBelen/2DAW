package org.iesbelen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.iesbelen.model.Fabricante;
import org.iesbelen.model.FabricanteDTO;

public class FabricanteDAOImpl extends AbstractDAOImpl implements FabricanteDAO{

	/**
	 * Inserta en base de datos el nuevo fabricante, actualizando el id en el bean fabricante.
	 */
	@Override	
	public synchronized void create(Fabricante fabricante) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
        	conn = connectDB();


        	//1 alternativas comentadas:
        	//ps = conn.prepareStatement("INSERT INTO fabricantes (nombre) VALUES (?)", new String[] {"codigo"});
        	//Ver también, AbstractDAOImpl.executeInsert ...
        	//Columna fabricante.codigo es clave primaria auto_increment, por ese motivo se omite de la sentencia SQL INSERT siguiente. 
        	ps = conn.prepareStatement("INSERT INTO fabricantes (nombre) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setString(idx++, fabricante.getNombre());

            int rows = ps.executeUpdate();
            if (rows == 0) 
            	System.out.println("INSERT de fabricante con 0 filas insertadas.");
            
            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next()) 
            	fabricante.setIdFabricante(rsGenKeys.getInt(1));
                      
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, ps, rs);
        }
        
	}

	/**
	 * Devuelve lista con todos los fabricantes.
	 */
	@Override
	public List<Fabricante> getAll() {
		
		Connection conn = null;
		Statement s = null;
        ResultSet rs = null;
        
        List<Fabricante> listFab = new ArrayList<>(); 
        
        try {
        	conn = connectDB();

        	// Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
        	s = conn.createStatement();
            		
        	rs = s.executeQuery("SELECT * FROM fabricantes");
            while (rs.next()) {
            	Fabricante fab = new Fabricante();
            	int idx = 1;
            	fab.setIdFabricante(rs.getInt(idx++));
            	fab.setNombre(rs.getString(idx));
            	listFab.add(fab);
            }
          
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, s, rs);
        }
        return listFab;
        
	}

	/**
	 * Devuelve Optional de fabricante con el ID dado.
	 */
	@Override
	public Optional<Fabricante> find(int id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	ps = conn.prepareStatement("SELECT * FROM fabricantes WHERE idFabricante = ?");
        	
        	int idx =  1;
        	ps.setInt(idx, id);
        	
        	rs = ps.executeQuery();
        	
        	if (rs.next()) {
        		Fabricante fab = new Fabricante();
        		idx = 1;
        		fab.setIdFabricante(rs.getInt(idx++));
        		fab.setNombre(rs.getString(idx));
        		
        		return Optional.of(fab);
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
	/**
	 * Actualiza fabricante con campos del bean fabricante según ID del mismo.
	 */
	@Override
	public void update(Fabricante fabricante) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	ps = conn.prepareStatement("UPDATE fabricantes SET nombre = ?  WHERE idFabricante = ?");
        	int idx = 1;
        	ps.setString(idx++, fabricante.getNombre());
        	ps.setInt(idx, fabricante.getIdFabricante());
        	
        	int rows = ps.executeUpdate();
        	
        	if (rows == 0) 
        		System.out.println("Update de fabricante con 0 registros actualizados.");
        	
        } catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, ps, rs);
        }
    
	}

	/**
	 * Borra fabricante con ID proporcionado.
	 */
	@Override
	public void delete(int id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	ps = conn.prepareStatement("DELETE FROM fabricantes WHERE idFabricante = ?");
        	int idx = 1;
        	ps.setInt(idx, id);
        	
        	int rows = ps.executeUpdate();
        	
        	if (rows == 0) 
        		System.out.println("Delete de fabricante con 0 registros eliminados.");
        	
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
			ps = conn.prepareStatement("SELECT COUNT(*) FROM productos WHERE idFabricante = ?");

			int idx = 1;
			ps.setInt(idx, id);

			rs = ps.executeQuery();

			// Esto lo hacemos por seguridad y mantener el formato, pero podríamos poner 1 directamente
			if (rs.next()) {
				idx = 1;

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
	public List<FabricanteDTO> getAllDTOPlusCountProductos() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FabricanteDTO> fabs = new ArrayList<>();

		try {
			conn = connectDB();

			String query = "select f.idFabricante, f.nombre, count(idProducto) " +
					"from fabricantes f left join productos p using (idFabricante) " +
					"group by idFabricante";

			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			int idx;

			while (rs.next()) {
				idx = 1;
				int idFab = rs.getInt(idx++);
				String nombre = rs.getString(idx++);
				int countProd = rs.getInt(idx);

				fabs.add(new FabricanteDTO(idFab, nombre, countProd));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeDb(conn, ps, rs);
		}
		return fabs;
	}

	@Override
	public List<FabricanteDTO> getAllDTOrderedByIdDesc() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FabricanteDTO> fabs = new ArrayList<>();

		try {
			conn = connectDB();

			String query = "SELECT f.idFabricante, f.nombre, count(idProducto)" +
					"FROM fabricantes f LEFT JOIN productos p USING (idFabricante)" +
					"GROUP BY idFabricante ORDER BY idFabricante DESC";

			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			int idx;

			while (rs.next()) {
				idx = 1;
				int idFab = rs.getInt(idx++);
				String nombre = rs.getString(idx++);
				int countProd = rs.getInt(idx);

				fabs.add(new FabricanteDTO(idFab, nombre, countProd));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeDb(conn, ps, rs);
		}
		return fabs;
	}

	@Override
	public List<FabricanteDTO> getAllDTOrderedByNameAsc() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FabricanteDTO> fabs = new ArrayList<>();

		try {
			conn = connectDB();

			String query = "SELECT f.idFabricante, f.nombre, count(idProducto)" +
					"FROM fabricantes f LEFT JOIN productos p USING (idFabricante)" +
					"GROUP BY idFabricante ORDER BY f.nombre";

			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			int idx;

			while (rs.next()) {
				idx = 1;
				int idFab = rs.getInt(idx++);
				String nombre = rs.getString(idx++);
				int countProd = rs.getInt(idx);

				fabs.add(new FabricanteDTO(idFab, nombre, countProd));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeDb(conn, ps, rs);
		}
		return fabs;
	}

	@Override
	public List<FabricanteDTO> getAllDTOrderedByNameDesc() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FabricanteDTO> fabs = new ArrayList<>();

		try {
			conn = connectDB();

			String query = "SELECT f.idFabricante, f.nombre, count(idProducto)" +
					"FROM fabricantes f LEFT JOIN productos p USING (idFabricante)" +
					"GROUP BY idFabricante ORDER BY f.nombre DESC";

			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			int idx;

			while (rs.next()) {
				idx = 1;
				int idFab = rs.getInt(idx++);
				String nombre = rs.getString(idx++);
				int countProd = rs.getInt(idx);

				fabs.add(new FabricanteDTO(idFab, nombre, countProd));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeDb(conn, ps, rs);
		}
		return fabs;
	}

	@Override
	public List<FabricanteDTO> getAllDTOrdered(String orden, String modo) {
		List<FabricanteDTO> fabs = new ArrayList<>();

		if ("codigo".equals(orden)) {
			if ("asc".equals(modo)) { fabs = getAllDTOPlusCountProductos(); }
			else if ("desc".equals(modo)) { fabs = getAllDTOrderedByIdDesc(); }
			else { fabs = getAllDTOPlusCountProductos(); }
		} else if ("nombre".equals(orden)) {
			if ("asc".equals(modo)) { fabs = getAllDTOrderedByNameAsc(); }
			else if ("desc".equals(modo)) { fabs = getAllDTOrderedByNameDesc(); }
			else { fabs = getAllDTOPlusCountProductos(); }
		} else {
			fabs = getAllDTOPlusCountProductos();
		}
		return fabs;
	}
}
