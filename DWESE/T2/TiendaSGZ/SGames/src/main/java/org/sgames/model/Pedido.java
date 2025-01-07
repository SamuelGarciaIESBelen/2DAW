package org.sgames.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private int idPedido;
    private int idUsuario;
    private String fecha;
    private List<Producto> productos;
    private Double total;

    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }

    public int getIdPedido() { return idPedido; }

    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdUsuario() { return idUsuario; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getFecha() { return fecha; }

    public void setProductos(List<Producto> productos) { this.productos = productos; }

    public List<Producto> getProductos() { return productos; }

    public void setTotal(Double total) { this.total = total; }

    public Double getTotal() { return total; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return idPedido == pedido.idPedido && idUsuario == pedido.idUsuario && Objects.equals(fecha, pedido.fecha) && Objects.equals(productos, pedido.productos) && Objects.equals(total, pedido.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, idUsuario, fecha, productos, total);
    }
}
