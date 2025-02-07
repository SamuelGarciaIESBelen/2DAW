package org.iesbelen.repository;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Slf4j
@Repository
public class PeliculaDAOImpl implements PeliculaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public synchronized void create(Pelicula pelicula) {

		String sqlInsert = """
							INSERT INTO pelicula (titulo, descripcion, anyo_lanzamiento, id_idioma, duracion) 
							VALUES  (     			?,         ?,         	?,       		?,    		?)
						   """;

		KeyHolder keyHolder = new GeneratedKeyHolder();

		int rows = jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id_pelicula" });
			int idx = 1;
			ps.setString(idx++, pelicula.getTitulo());
			ps.setString(idx++, pelicula.getDescripcion());
			ps.setInt(idx++, pelicula.getAnyo_lanzamiento());
			ps.setInt(idx++, pelicula.getId_idioma());
			ps.setInt(idx, pelicula.getDuracion());
			return ps;
		},keyHolder);

		pelicula.setId_pelicula(keyHolder.getKey().intValue());

		log.info("Insertados {} registros.", rows);
	}

	@Override
	public List<Pelicula> getAll() {
		
		List<Pelicula> listPelicula = jdbcTemplate.query(
                "SELECT id_pelicula, titulo, descripcion, anyo_lanzamiento, id_idioma, duracion FROM pelicula",
                (rs, rowNum) -> Pelicula.builder()
						.id_pelicula(rs.getInt("id_pelicula"))
						.titulo(rs.getString("titulo"))
						.descripcion(rs.getString("descripcion"))
						.anyo_lanzamiento(rs.getInt("anyo_lanzamiento"))
						.id_idioma(rs.getInt("id_idioma"))
						.duracion(rs.getInt("duracion"))
						.build()
        );
		
		log.info("Devueltos {} registros.", listPelicula.size());
		
        return listPelicula;
	}

	@Override
	public List<Pelicula> getAllByCategoria(int id_categoria) {
		List<Pelicula> listPelicula = jdbcTemplate.query(
				"SELECT id_pelicula, titulo, descripcion, anyo_lanzamiento, id_idioma, duracion FROM pelicula WHERE id_categoria = ?",
				(rs, rowNum) -> Pelicula.builder()
						.id_pelicula(rs.getInt("id_pelicula"))
						.titulo(rs.getString("titulo"))
						.descripcion(rs.getString("descripcion"))
						.anyo_lanzamiento(rs.getInt("anyo_lanzamiento"))
						.id_idioma(rs.getInt("id_idioma"))
						.duracion(rs.getInt("duracion"))
						.build()
				, id_categoria
		);

		log.info("Devueltos {} pedidos del cliente con id {}.", listPelicula.size(), id_categoria);

		return listPelicula;
	}
}
