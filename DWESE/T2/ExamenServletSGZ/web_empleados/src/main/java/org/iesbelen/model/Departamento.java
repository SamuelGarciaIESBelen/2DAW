package org.iesbelen.model;

import java.util.Objects;

public class Departamento {
    private int codigo;
    private String nombre;
    private int presupuesto;
    private int gastos;

    public void setCodigo(int codigo) { this.codigo = codigo; }

    public int getCodigo() { return codigo; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNombre() { return nombre; }

    public void setPresupuesto(int presupuesto) { this.presupuesto = presupuesto; }

    public int getPresupuesto() { return presupuesto; }

    public void setGastos(int gastos) { this.gastos = gastos; }

    public int getGastos() { return gastos; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departamento that)) return false;
        return codigo == that.codigo && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre);
    }
}
