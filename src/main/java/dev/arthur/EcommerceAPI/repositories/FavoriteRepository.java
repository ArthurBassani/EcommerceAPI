package dev.arthur.EcommerceAPI.repositories;

import dev.arthur.EcommerceAPI.models.favorite.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FavoriteRepository extends JpaRepository<Favorite, UUID> {
}
