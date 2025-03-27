package dev.arthur.EcommerceAPI.models.productCart;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class ProductCartId {

    @Column(name = "id_product")
    private UUID productId;

    @Column(name = "id_cart")
    private UUID cartId;

}
