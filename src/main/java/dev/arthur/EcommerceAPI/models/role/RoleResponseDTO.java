package dev.arthur.EcommerceAPI.models.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponseDTO {
    private UUID id;
    private String name;
    private Instant createdAt;
    private Instant updatedAt;
}
