package dev.arthur.EcommerceAPI.exceptions.cart;

import jakarta.persistence.EntityNotFoundException;

public class CartNotFoundException extends EntityNotFoundException {

    public CartNotFoundException(){ super("Cart Not Found"); }

    public CartNotFoundException(String message){ super(message); }

}
