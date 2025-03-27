package dev.arthur.EcommerceAPI.models.productShop;

import dev.arthur.EcommerceAPI.models.product.Product;
import dev.arthur.EcommerceAPI.models.shop.Shop;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "products_shopping")
@NoArgsConstructor
@AllArgsConstructor
public class ProductShop {
    @EmbeddedId
    private ProductShopId id;

    @Column(name = "buy_price")
    private BigDecimal buyPrice;

    private BigInteger quantity;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @MapsId("shopId")
    @JoinColumn(name = "id_shop")
    private Shop shop;

}
