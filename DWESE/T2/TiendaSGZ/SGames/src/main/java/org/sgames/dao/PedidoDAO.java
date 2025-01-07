package org.sgames.dao;

import org.sgames.model.Pedido;
import org.sgames.model.Producto;

import java.util.List;
import java.util.Optional;

public interface PedidoDAO {
    public void create(Pedido producto);
    public List<Pedido> getAll();
    public Optional<Pedido> find(int id);
    public void update(Pedido producto);
    public void delete(int id);

    void createConProductos(Pedido pedido, List<Producto> productos, List<Integer> cantidades);
    List<Producto> getProductos(int idPedido);
    List<Integer> getCantidades(int idPedido);
    List<Pedido> getPedidosByCliente(int idUsuario);
}
