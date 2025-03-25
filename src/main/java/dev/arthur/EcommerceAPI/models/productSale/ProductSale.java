package dev.arthur.EcommerceAPI.models.productSale;

import dev.arthur.EcommerceAPI.models.product.Product;
import dev.arthur.EcommerceAPI.models.sale.Sale;
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
@Table(name="products_sales")
@NoArgsConstructor
@AllArgsConstructor
public class ProductSale {
    @EmbeddedId
    private ProductSaleId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @MapsId("saleId")
    @JoinColumn(name = "id_sale")
    private Sale sale;

    private BigDecimal sale_price;

    private BigInteger quantity;

}
