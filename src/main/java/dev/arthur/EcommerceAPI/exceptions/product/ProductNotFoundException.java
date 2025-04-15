package dev.arthur.EcommerceAPI.exceptions.product;


public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(){ super("Product Not Found"); }

    public ProductNotFoundException(String message){ super(message); }

}
