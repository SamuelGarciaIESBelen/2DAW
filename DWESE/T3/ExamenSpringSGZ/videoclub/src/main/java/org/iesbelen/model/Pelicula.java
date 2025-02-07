package org.iesbelen.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pelicula {
    private int id_pelicula;

    @NotBlank(message = "{tituloVacio}")
    @Size(min = 2, message = "{tituloMin}")
    private String titulo;

    @Size(max = 2, message = "{descMax}")
    private String descripcion;

    @Min(value = 1896, message = "{yearMin}")
    private int anyo_lanzamiento;

    private int id_idioma;

    @Min(value = 1, message = "{durationMin}")
    private int duracion;

}
