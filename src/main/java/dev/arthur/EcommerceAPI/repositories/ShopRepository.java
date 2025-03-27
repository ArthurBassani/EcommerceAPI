package dev.arthur.EcommerceAPI.repositories;

import dev.arthur.EcommerceAPI.models.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShopRepository extends JpaRepository<Shop, UUID> {
}
