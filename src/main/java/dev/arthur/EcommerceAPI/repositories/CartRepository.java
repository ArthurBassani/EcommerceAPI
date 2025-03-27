package dev.arthur.EcommerceAPI.repositories;

import dev.arthur.EcommerceAPI.models.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {

}
