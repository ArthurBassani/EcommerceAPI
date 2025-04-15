package dev.arthur.EcommerceAPI.repositories;

import dev.arthur.EcommerceAPI.models.productCart.ProductCart;
import dev.arthur.EcommerceAPI.models.productCart.ProductCartId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductCartRepository extends JpaRepository<ProductCart, ProductCartId> {

    public List<ProductCart> findByCartId(UUID id);

    public void deleteByProductAndCartId(UUID productId, UUID cartId);

}
