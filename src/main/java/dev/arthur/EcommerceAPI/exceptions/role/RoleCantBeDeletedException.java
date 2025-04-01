package dev.arthur.EcommerceAPI.exceptions.role;

import org.springframework.dao.DataIntegrityViolationException;

public class RoleCantBeDeletedException extends RuntimeException {
    public RoleCantBeDeletedException() { super("Role Cant Be Deleted, There Are Linked Entities"); }
}
