package dev.arthur.EcommerceAPI.models.productShop;

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
public class ProductShopId {
    @Column(name = "id_product")
    private UUID productId;

    @Column(name = "id_shop")
    private UUID shopId;

}
