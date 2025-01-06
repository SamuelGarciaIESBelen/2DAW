package org.sgames.model;

import java.util.Date;
import java.util.Objects;

public class Pedido {
    private int idPedido;
    private int idCliente;
    private Date fecha;

    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }

    public int getIdPedido() { return idPedido; }

    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdCliente() { return idCliente; }

    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Date getFecha() { return fecha; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return idPedido == pedido.idPedido && idCliente == pedido.idCliente && Objects.equals(fecha, pedido.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, idCliente, fecha);
    }
}
