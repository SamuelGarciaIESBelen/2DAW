package org.iesbelen.model;

import java.util.Objects;

public class Empleado {
    private int codigo;
    private String nif;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int codigoDep;

    public void setCodigo(int codigo) { this.codigo = codigo; }

    public int getCodigo() { return codigo; }

    public void setNif(String nif) { this.nif = nif; }

    public String getNif() { return nif; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNombre() { return nombre; }

    public void setApellido1(String apellido1) { this.apellido1 = apellido1; }

    public String getApellido1() { return apellido1; }

    public void setApellido2(String apellido2) { this.apellido2 = apellido2; }

    public String getApellido2() { return apellido2; }

    public void setCodigoDep(int codigo_dep) { this.codigoDep = codigo_dep; }

    public int getCodigoDep() { return codigoDep; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleado empleado)) return false;
        return codigo == empleado.codigo && Objects.equals(nif, empleado.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nif);
    }
}
