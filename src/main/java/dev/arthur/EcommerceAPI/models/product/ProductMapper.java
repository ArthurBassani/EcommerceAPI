package dev.arthur.EcommerceAPI.models.product;

import dev.arthur.EcommerceAPI.dtos.product.ProductRequestDTO;
import dev.arthur.EcommerceAPI.dtos.product.ProductResponseDTO;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class ProductMapper {

    public ProductResponseDTO entityToResponse(Product product) {
        return new ProductResponseDTO(
                product.getId(),product.getName(),
                product.getDescription(),product.getPrice(),
                product.getStockQuantity(),product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }

    public Product requestToEntity(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setStockQuantity(productRequestDTO.getStockQuantity());

        product.setProductCarts(new HashSet<>());
        product.setFavorites(new HashSet<>());
        product.setProductSales(new HashSet<>());
        product.setProductShopping(new HashSet<>());

        return product;
    }
}
