package org.iesbelen.examensgz.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @NaturalId
    private String email;

    private String username;
    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    Set<Product> products = new HashSet<>();

    public void setId(long id) { this.id = id; }
    public long getId() { return id; }

    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }

    public void setUsername(String username) { this.username = username; }
    public String getUsername() { return username; }

    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password; }

    public void setProducts(Set<Product> products) { this.products = products; }
    public Set<Product> getProducts() { return products; }
}
