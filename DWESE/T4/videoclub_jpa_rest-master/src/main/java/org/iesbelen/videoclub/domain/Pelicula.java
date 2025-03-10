package org.iesbelen.videoclub.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pelicula")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idPelicula") // Para que funcione la colección Set<Pelicula> en Categoria
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pelicula")
    private long idPelicula;

    private String titulo;

    private String descripcion;

    @Column(name = "anyo_lanzamiento")
    @JsonFormat(pattern = "yyyy",  shape = JsonFormat.Shape.STRING)
    private Date anyoLanzamiento;

    @ManyToOne()
    @JoinColumn(name = "id_idioma", nullable = false)
    private Idioma idioma;

    private int duracion;

    // @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pelicula_categoria",
                joinColumns = @JoinColumn(name = "id_pelicula", referencedColumnName = "id_pelicula"),
                inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria"))
    Set<Categoria> categorias = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pelicula_actor",
                joinColumns = @JoinColumn(name = "id_pelicula", referencedColumnName = "id_pelicula"),
                inverseJoinColumns = @JoinColumn(name = "id_actor", referencedColumnName = "id_actor"))
    Set<Actor> actores = new HashSet<>();
}
