package dev.arthur.EcommerceAPI.dtos.productCart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ProductCartResponseDTO {
    private UUID cartId;
    private UUID productId;
    private BigInteger quantity;
}
