package org.sgames.model;

import java.util.Objects;

public class Categoria {
    private int idCategoria;
    private String nombre;

    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public int getIdCategoria() { return idCategoria; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNombre() { return nombre; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return idCategoria == categoria.idCategoria && Objects.equals(nombre, categoria.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, nombre);
    }
}
