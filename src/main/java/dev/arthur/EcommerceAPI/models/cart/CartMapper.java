package dev.arthur.EcommerceAPI.models.cart;

import dev.arthur.EcommerceAPI.dtos.cart.CartResponseDTO;
import dev.arthur.EcommerceAPI.dtos.productCart.ProductCartResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartMapper {

    public CartResponseDTO entityToResponse(Cart cart,
                                            List<ProductCartResponseDTO> productCartResponseDTOList){
        return new CartResponseDTO(
                cart.getId(), cart.getUser().getId(),
                cart.getTotalValue(),productCartResponseDTOList
        );
    }
}
