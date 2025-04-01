package dev.arthur.EcommerceAPI.repositories;

import dev.arthur.EcommerceAPI.models.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    public Role findRoleByName(String name);

    public Boolean existsByName(String name);
}
