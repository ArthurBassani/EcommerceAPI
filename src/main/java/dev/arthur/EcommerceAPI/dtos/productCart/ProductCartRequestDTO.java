package dev.arthur.EcommerceAPI.dtos.productCart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartRequestDTO {
    private UUID productId;
    private UUID cartId;
    private BigInteger quantity;
}
