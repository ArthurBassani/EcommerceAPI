package dev.arthur.EcommerceAPI.models.address;

import dev.arthur.EcommerceAPI.models.city.City;
import dev.arthur.EcommerceAPI.models.sale.Sale;
import dev.arthur.EcommerceAPI.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String street;
    private BigInteger number;
    private String complement;

    @Column(name = "reference_point")
    private String referencePoint;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @OneToMany(mappedBy = "address")
    private Set<Sale> sales;

    @ManyToOne
    @JoinColumn(name = "id_city")
    private City city;

    @ManyToMany(mappedBy = "addresses")
    private Set<User> users;

}
