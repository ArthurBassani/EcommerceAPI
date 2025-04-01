package dev.arthur.EcommerceAPI.exceptions.role;

import jakarta.persistence.EntityNotFoundException;

public class RoleNotFoundException extends EntityNotFoundException {

    public RoleNotFoundException(){ super("Role Not Found"); }

    public RoleNotFoundException(String message){ super(message); }

}
