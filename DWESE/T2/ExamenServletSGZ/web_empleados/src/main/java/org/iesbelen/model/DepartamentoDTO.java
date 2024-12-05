package org.iesbelen.model;

public class DepartamentoDTO extends Departamento {
    private int numEmpleados;

    public DepartamentoDTO() {}

    // Al final era más cómodo hacer esto para el getAllDTO()
    public DepartamentoDTO(int codigo, String nombre, int presupuesto, int gastos, int numEmpleados) {
        setCodigo(codigo);
        setNombre(nombre);
        setPresupuesto(presupuesto);
        setGastos(gastos);
        this.numEmpleados = numEmpleados;
    }

    public DepartamentoDTO(Departamento dep, int numEmpleados) {
        setCodigo(dep.getCodigo());
        setNombre(dep.getNombre());
        setPresupuesto(dep.getPresupuesto());
        setGastos(dep.getGastos());
        this.numEmpleados = numEmpleados;
    }

    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }
}
