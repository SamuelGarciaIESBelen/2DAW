package org.iesbelen.tienda_informatica.dao;

import java.util.List;
import java.util.Optional;

import org.iesbelen.tienda_informatica.modelo.Fabricante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class FabricanteDAOImpl  implements FabricanteDAO{

	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	/**
	 * Inserta en base de datos el nuevo fabricante, actualizando el id en el bean fabricante.
	 */
	@Override	
	public synchronized void create(Fabricante fabricante) {

		jdbcTemplate.update("INSERT INTO fabricantes (nombre) VALUES (?)",fabricante.getNombre());
		
	}

	/**
	 * Devuelve lista con todos los fabricantes.
	 */
	@Override
	public List<Fabricante> getAll() {
		
		List<Fabricante> listFab = jdbcTemplate.query(
                "SELECT * FROM fabricantes",
                (rs, rowNum) -> new Fabricante(rs.getInt("codigo"),rs.getString("nombre"))
        );
			
        return listFab;
        
	}

	/**
	 * Devuelve Optional de fabricante con el ID dado.
	 */
	@Override
	public Optional<Fabricante> find(int id) {
		
		Fabricante fab =  jdbcTemplate
				.queryForObject("SELECT * FROM fabricantes WHERE codigo = ?"
								, (rs, rowNum) -> new Fabricante(rs.getInt("codigo"),rs.getString("nombre"))  
								, id
								);
		
		if (fab != null) return Optional.of(fab);
		else return Optional.empty();
        
	}
	/**
	 * Actualiza fabricante con campos del bean fabricante según ID del mismo.
	 */
	@Override
	public void update(Fabricante fabricante) {
		
		int rows = jdbcTemplate.update("UPDATE fabricantes SET nombre = ?  WHERE codigo = ?", fabricante.getNombre(), fabricante.getCodigo());
		if (rows == 0) System.out.println("Update de fabricante con 0 registros actualizados.");
    
	}

	/**
	 * Borra fabricante con ID proporcionado.
	 */
	@Override
	public void delete(int id) {
		
		int rows = jdbcTemplate.update("DELETE FROM fabricantes WHERE codigo = ?", id);
		
		if (rows == 0) System.out.println("Delete de fabricante con 0 registros actualizados.");
		
	}

}
