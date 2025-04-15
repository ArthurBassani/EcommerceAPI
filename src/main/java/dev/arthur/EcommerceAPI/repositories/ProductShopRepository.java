package dev.arthur.EcommerceAPI.repositories;

import dev.arthur.EcommerceAPI.models.productShop.ProductShop;
import dev.arthur.EcommerceAPI.models.productShop.ProductShopId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductShopRepository extends JpaRepository<ProductShop, ProductShopId> {
}
