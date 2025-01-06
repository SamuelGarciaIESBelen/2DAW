package org.sgames.model;

public class CategoriaDTO extends Categoria {
    private int numProductos;

    public CategoriaDTO() {}

    public CategoriaDTO(int id, String nombre, int numProductos) {
        setIdCategoria(id);
        setNombre(nombre);
        this.numProductos = numProductos;
    }

    public CategoriaDTO(Categoria cat, int numProductos) {
        setIdCategoria(cat.getIdCategoria());
        setNombre(cat.getNombre());
        this.numProductos = numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }

    public int getNumProductos() {
        return numProductos;
    }
}
