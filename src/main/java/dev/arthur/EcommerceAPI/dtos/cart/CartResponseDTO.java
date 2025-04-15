package dev.arthur.EcommerceAPI.dtos.cart;

import dev.arthur.EcommerceAPI.dtos.productCart.ProductCartResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class CartResponseDTO {
    private UUID id;
    private UUID userId;
    private BigDecimal totalValue;
    private List<ProductCartResponseDTO> productCartList;
}
