package dev.arthur.EcommerceAPI.models.productCart;

import dev.arthur.EcommerceAPI.models.cart.Cart;
import dev.arthur.EcommerceAPI.models.product.Product;
import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "products_carts")
public class ProductCarts {
    @EmbeddedId
    private ProductCartsId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "id_cart")
    private Cart cart;

    private BigInteger quantity;
}
