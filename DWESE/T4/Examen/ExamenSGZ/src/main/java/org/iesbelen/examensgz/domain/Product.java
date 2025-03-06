package org.iesbelen.examensgz.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "name")
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    private String name;
    private String descrip;
    private String image_url;
    private double price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cart_item",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    Set<User> users = new HashSet<>();

    public void setId(long id) { this.id = id; }
    public long getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setDescrip(String descrip) { this.descrip = descrip; }
    public String getDescrip() { return descrip; }

    public void setImage_url(String image_url) { this.image_url = image_url; }
    public String getImage_url() { return image_url; }

    public void setPrice(double price) { this.price = price; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getQuantity() { return quantity; }

    public void setCategory(Category category) { this.category = category; }
    public Category getCategory() { return category; }

    public void setUsers(Set<User> users) { this.users = users; }
    public Set<User> getUsers() { return users; }
}
