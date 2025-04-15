package dev.arthur.EcommerceAPI.repositories;

import dev.arthur.EcommerceAPI.models.productSale.ProductSale;
import dev.arthur.EcommerceAPI.models.productSale.ProductSaleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSaleRepository extends JpaRepository<ProductSale, ProductSaleId> {
}
