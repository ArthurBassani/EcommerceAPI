package dev.arthur.EcommerceAPI.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDTO {
    private UUID id;
    private String name;
    private String document;
    private String email;
    private String phone;
    private Date birthdate;
    private UUID roleId;
    private UUID favoriteId;
    private UUID cartId;
}
