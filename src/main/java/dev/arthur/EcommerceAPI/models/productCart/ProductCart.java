package dev.arthur.EcommerceAPI.models.productCart;

import dev.arthur.EcommerceAPI.models.cart.Cart;
import dev.arthur.EcommerceAPI.models.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products_carts")
public class ProductCart {
    @EmbeddedId
    private ProductCartId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "id_cart")
    private Cart cart;

    private BigInteger quantity;

    public void increaseQuantity(BigInteger amount){
        this.quantity = this.quantity.add(amount);
    }

    public void decreaseQuantity(BigInteger amount){
        this.quantity = this.quantity.subtract(amount);
    }
}
