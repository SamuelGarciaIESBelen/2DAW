package org.iesbelen.videoclub.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id") // Para que funcione la colección Set<Actor> en Pelicula
@Builder
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actor")
    private long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellidos;

    @JsonIgnore
    @ManyToMany(mappedBy = "actores")
    @ToString.Exclude
    private Set<Pelicula> peliculas = new HashSet<>();
}
