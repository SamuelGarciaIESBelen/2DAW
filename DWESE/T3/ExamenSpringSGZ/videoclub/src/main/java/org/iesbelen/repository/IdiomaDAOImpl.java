package org.iesbelen.repository;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.model.Idioma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Slf4j
@Repository
public class IdiomaDAOImpl implements IdiomaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Idioma> getAll() {
		
		List<Idioma> listIdioma = jdbcTemplate.query(
                "SELECT id_idioma, nombre FROM idioma",
                (rs, rowNum) -> Idioma.builder()
						.id_idioma(rs.getInt("id_idioma"))
						.nombre(rs.getString("nombre"))
						.build()
        );
		
		log.info("Devueltos {} registros.", listIdioma.size());
		
        return listIdioma;
	}
}
