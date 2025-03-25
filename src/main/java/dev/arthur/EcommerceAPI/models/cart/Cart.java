package dev.arthur.EcommerceAPI.models.cart;

import dev.arthur.EcommerceAPI.models.productCart.ProductCarts;
import dev.arthur.EcommerceAPI.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="carts")
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private BigDecimal total_value;

    @OneToMany(mappedBy = "cart")
    private Set<ProductCarts> productCarts;

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

}
