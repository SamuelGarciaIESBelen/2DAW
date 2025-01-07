package org.sgames.dao;

import org.sgames.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoDAO {
    public void create(Pedido producto);
    public List<Pedido> getAll();
    public Optional<Pedido>  find(int id);
    public void update(Pedido producto);
    public void delete(int id);

    public List<Pedido> filterByUser(int idUsuario);
}
