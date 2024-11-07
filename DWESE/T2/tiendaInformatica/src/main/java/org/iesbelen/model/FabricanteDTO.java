package org.iesbelen.model;

public class FabricanteDTO extends Fabricante {
    private int numProductos;

    public FabricanteDTO() {}

    public FabricanteDTO(int id, String nombre, int numProductos) {
        super();
        this.numProductos = numProductos;
    }

    public FabricanteDTO(Fabricante fab, int numProductos) {
        setIdFabricante(fab.getIdFabricante());
        setNombre(fab.getNombre());
        this.numProductos = numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }

    public int getNumProductos() {
        return numProductos;
    }
}
