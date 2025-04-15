package dev.arthur.EcommerceAPI.models.productCart;

import dev.arthur.EcommerceAPI.dtos.productCart.ProductCartResponseDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ProductCartMapper {

    public List<ProductCartResponseDTO> entitySetToResponseList(Set<ProductCart> productCartSet){
        List<ProductCartResponseDTO> productCartResponseDTOList = new ArrayList<>();

        for (ProductCart productCart : productCartSet){
            productCartResponseDTOList.add(
                    this.entityToResponse(productCart)
            );
        }
        return productCartResponseDTOList;
    }

    public ProductCartResponseDTO entityToResponse(ProductCart productCart){
        return new ProductCartResponseDTO(
                productCart.getCart().getId(), productCart.getProduct().getId(),
                productCart.getQuantity());
    }

}
