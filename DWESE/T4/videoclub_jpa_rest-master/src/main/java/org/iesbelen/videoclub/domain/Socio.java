package org.iesbelen.videoclub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="socio")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NaturalId
    private String dni;

    private String nombre;

    private String apellidos;

    @OneToOne
    @JoinColumn(name = "tarjeta_id", referencedColumnName = "id")
    private Tarjeta tarjeta;
}
