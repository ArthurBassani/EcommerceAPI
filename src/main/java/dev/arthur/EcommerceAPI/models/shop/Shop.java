package dev.arthur.EcommerceAPI.models.shop;

import dev.arthur.EcommerceAPI.models.productShop.ProductShop;
import dev.arthur.EcommerceAPI.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "shopping")
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private ZonedDateTime date;

    @Column(name = "total_value")
    private BigDecimal totalValue;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;


    @OneToMany(mappedBy = "shop")
    private Set<ProductShop> productShopping;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
