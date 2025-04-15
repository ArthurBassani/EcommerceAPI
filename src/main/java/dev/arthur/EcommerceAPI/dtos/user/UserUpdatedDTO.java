package dev.arthur.EcommerceAPI.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdatedDTO {
    private UUID id;
    private String name;
    private String email;
    private List<String> updatedProperties;
}
