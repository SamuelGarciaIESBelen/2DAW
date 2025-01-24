package org.iesbelen.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Pedido {
    private int id;
    private double total;
    private LocalDate fecha;
    private int id_cliente;
    private int id_comercial;
}
