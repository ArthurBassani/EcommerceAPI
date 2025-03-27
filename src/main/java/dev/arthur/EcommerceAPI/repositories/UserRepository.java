package dev.arthur.EcommerceAPI.repositories;


import dev.arthur.EcommerceAPI.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    public User findUserByName(String name);
}
