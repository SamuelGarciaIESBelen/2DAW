package org.iesbelen.elementcollection.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private int id;
    private String street;
    private int houseNumber;
    private String city;
    private int zipCode;
}
