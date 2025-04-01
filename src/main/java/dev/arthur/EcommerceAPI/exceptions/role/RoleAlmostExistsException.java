package dev.arthur.EcommerceAPI.exceptions.role;

public class RoleAlmostExistsException extends RuntimeException {

    public RoleAlmostExistsException(){ super("Role Almost Exists"); }

    public RoleAlmostExistsException(String message){ super(message); }

}
