package org.iesbelen.dto;

import org.iesbelen.model.Departamento;

public class DepartamentoDTO extends Departamento {
    private int numEmpleados;

    public DepartamentoDTO() {}

    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }
}
