package org.iesbelen.modelo;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Comercial {

	private int id;

	@NotBlank(message = "{nombreVacio}")
	@Size(max = 30, message = "{nombreMax}")
	private String nombre;

	@NotBlank(message = "{ape1Vacio}")
	@Size(max = 30, message = "{ape1Max}")
	private String apellido1;

	@Size(max = 30, message = "{ape2Max}")
	private String apellido2;

	@DecimalMin(value = "0.276", inclusive = true, message = "{comisionError}")
	@DecimalMax(value = "0.946", inclusive = true, message = "{comisionError}")
	private BigDecimal comision;

	public Comercial() { }
}
