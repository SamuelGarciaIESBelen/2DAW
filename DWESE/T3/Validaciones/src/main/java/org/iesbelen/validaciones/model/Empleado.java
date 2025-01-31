package org.iesbelen.validaciones.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Empleado {

    @NotBlank(message = "{nombreVacio}")
    @Size(min = 4, message = "{nombreMin}")
    @Size(max = 10, message = "{nombreMax}")
    private String nombre;

    @NotNull(message = "{salarioVacio}")
    @Min(value = 1000, message = "{salarioMin}")
    @Max(value = 10000, message = "{salarioMax}")
    private Double salario;

    @Email(message = "{emailFormato}", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
    private String email;
}
