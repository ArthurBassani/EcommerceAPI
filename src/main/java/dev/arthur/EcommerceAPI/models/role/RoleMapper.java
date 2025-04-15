package dev.arthur.EcommerceAPI.models.role;

import dev.arthur.EcommerceAPI.dtos.role.RoleResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleResponseDTO entityToResponse(Role role){
        return new RoleResponseDTO(
                role.getId(), role.getName(),
                role.getCreatedAt(),role.getUpdatedAt()
        );
    }
}
