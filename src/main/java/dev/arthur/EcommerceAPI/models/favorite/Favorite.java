package dev.arthur.EcommerceAPI.models.favorite;

import dev.arthur.EcommerceAPI.models.product.Product;
import dev.arthur.EcommerceAPI.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="favorites")
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "products_favorites",
            joinColumns = @JoinColumn(name = "id_favorite"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private Set<Product> products;
}
