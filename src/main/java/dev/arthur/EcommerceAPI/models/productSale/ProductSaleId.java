package dev.arthur.EcommerceAPI.models.productSale;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaleId {
    @Column(name = "id_product")
    private UUID productId;

    @Column(name = "id_sale")
    private UUID saleId;
}
