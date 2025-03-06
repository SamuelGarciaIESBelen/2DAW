package org.iesbelen.examensgz.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long id;

    private String name;
    private String descrip;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    Set<Product> products = new HashSet<>();

    public void setId(long id) { this.id = id; }
    public long getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setDescrip(String descrip) { this.descrip = descrip; }
    public String getDescrip() { return descrip; }

    public void setProducts(Set<Product> products) { this.products = products; }
    public Set<Product> getProducts() { return products; }
}
