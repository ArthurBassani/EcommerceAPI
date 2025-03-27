package dev.arthur.EcommerceAPI.repositories;

import dev.arthur.EcommerceAPI.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
