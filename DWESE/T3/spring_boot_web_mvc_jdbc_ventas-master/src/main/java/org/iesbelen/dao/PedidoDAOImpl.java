package org.iesbelen.dao;

import java.util.List;

import org.iesbelen.modelo.Pedido;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@AllArgsConstructor
public class PedidoDAOImpl implements PedidoDAO {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Pedido> getAll() {
        List<Pedido> listPedido = jdbcTemplate.query(
                "SELECT * FROM pedido",
                (rs, rowNum) -> new Pedido(rs.getInt("id"),
                        rs.getDouble("total"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_comercial"))
        );

        log.info("Devueltos {} registros.", listPedido.size());

        return listPedido;
    }

    @Override
    public List<Pedido> getAllByComercial(int idComercial) {
        List<Pedido> listPedido = jdbcTemplate.query(
                "SELECT * FROM pedido WHERE id_comercial = ?",
                (rs, rowNum) -> new Pedido(rs.getInt("id"),
                        rs.getDouble("total"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_comercial"))
                , idComercial
        );

        log.info("Devueltos {} registros del comerciante con id {}.", listPedido.size(), idComercial);

        return listPedido;
    }
}
