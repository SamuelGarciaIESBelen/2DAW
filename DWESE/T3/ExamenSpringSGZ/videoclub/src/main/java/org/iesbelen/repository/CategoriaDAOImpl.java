package org.iesbelen.repository;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Categoria> getAll() {
		
		List<Categoria> listCategoria = jdbcTemplate.query(
                "SELECT id_categoria, nombre FROM categoria",
                (rs, rowNum) -> Categoria.builder()
						.id_categoria(rs.getInt("id_categoria"))
						.nombre(rs.getString("nombre"))
						.build()
        );
		
		log.info("Devueltos {} registros.", listCategoria.size());
		
        return listCategoria;
	}

	@Override
	public Optional<Categoria> find(int id) {
		
		Categoria cat =  jdbcTemplate
				.queryForObject("SELECT id_categoria, nombre FROM categoria WHERE id_categoria = ?"
								, (rs, rowNum) -> Categoria.builder()
											.id_categoria(rs.getInt("id_categoria"))
											.nombre(rs.getString("nombre"))
											.build()
								, id
								);
		
		if (cat != null) {
			return Optional.of(cat);
		} else {
			log.info("Categoria no encontrada.");
			return Optional.empty();
		}
	}
}
