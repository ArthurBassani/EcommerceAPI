package dev.arthur.EcommerceAPI.models.product;

import dev.arthur.EcommerceAPI.models.favorite.Favorite;
import dev.arthur.EcommerceAPI.models.productSale.ProductSale;
import dev.arthur.EcommerceAPI.models.productCart.ProductCarts;
import dev.arthur.EcommerceAPI.models.productsShopping.ProductShop;
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
    private BigInteger stock_quantity;

    @OneToMany(mappedBy = "product")
    private Set<ProductShop> productShopping;

    @OneToMany(mappedBy = "product")
    private Set<ProductSale> productSales;

    @OneToMany(mappedBy = "product")
    private Set<ProductCarts> productCarts;

    @ManyToMany(mappedBy = "products")
    private Set<Favorite> favorites;
}
