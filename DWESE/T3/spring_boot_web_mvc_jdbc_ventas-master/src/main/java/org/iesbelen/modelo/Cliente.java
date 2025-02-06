package org.iesbelen.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.iesbelen.validator.RangoCategoriaValidator;

//La anotación @Data de lombok proporcionará el código de:
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
public class Cliente {

	/*
	@Builder
	Person.builder()
		.name("Adam Savage")
		.city("San Francisco")
		.job("Mythbusters")
		.job("Unchained Reaction")
		.build();
	*/

	private long id;

	@NotBlank(message = "{nombreVacio}")
	@Size(max = 30, message = "{nombreMax}")
	private String nombre;

	@NotBlank(message = "{ape1Vacio}")
	@Size(max = 30, message = "{ape1Max}")
	private String apellido1;

	@Size(max = 30, message = "{ape2Max}")
	private String apellido2;

	@NotNull(message = "{ciudadVacia}")
	@Size(max = 50, message = "{ciudadMax}")
	private String ciudad;

	@RangoCategoriaValidator
	private int categoria;

	public Cliente() { }
	
}
