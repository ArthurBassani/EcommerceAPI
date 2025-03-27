package dev.arthur.EcommerceAPI.models.product;

import dev.arthur.EcommerceAPI.models.favorite.Favorite;
import dev.arthur.EcommerceAPI.models.productSale.ProductSale;
import dev.arthur.EcommerceAPI.models.productCart.ProductCart;
import dev.arthur.EcommerceAPI.models.productShop.ProductShop;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;

    @Column(name = "stock_quantity")
    private BigInteger stockQuantity;

    @OneToMany(mappedBy = "product")
    private Set<ProductShop> productShopping;

    @OneToMany(mappedBy = "product")
    private Set<ProductSale> productSales;

    @OneToMany(mappedBy = "product")
    private Set<ProductCart> productCarts;

    @ManyToMany(mappedBy = "products")
    private Set<Favorite> favorites;
}
