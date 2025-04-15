package dev.arthur.EcommerceAPI.dtos.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class UserRequestDTO {
    private String name;
    private String document;
    private String email;
    private String password;
    private String phone;
    private Date birthdate;
    private UUID roleId;
}
