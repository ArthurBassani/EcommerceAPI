package dev.arthur.EcommerceAPI.models.role;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDeletedDTO {
    private String message;
    private String name;
    private Instant deletedAt;
}
