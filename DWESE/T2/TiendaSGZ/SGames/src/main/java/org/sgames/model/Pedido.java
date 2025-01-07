package org.sgames.model;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class Pedido {
    private int idPedido;
    private int idUsuario;
    private LocalDate fecha;
    private double total;
    private Map<Integer, Integer> productos;

    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }

    public int getIdPedido() { return idPedido; }

    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdUsuario() { return idUsuario; }

    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalDate getFecha() { return fecha; }

    public void setTotal(double total) { this.total = total; }

    public double getTotal() { return total; }

    public void setProductos(Map<Integer, Integer> productos) { this.productos = productos; }

    public Map<Integer, Integer> getProductos() { return productos; }

    public void agregarProducto (int idProducto, int cantidad){
        productos.put(idProducto, cantidad);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return idPedido == pedido.idPedido && idUsuario == pedido.idUsuario && Double.compare(total, pedido.total) == 0 && Objects.equals(fecha, pedido.fecha) && Objects.equals(productos, pedido.productos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, idUsuario, fecha, total, productos);
    }
}
