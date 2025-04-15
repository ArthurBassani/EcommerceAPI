package dev.arthur.EcommerceAPI.exceptions.product;

public class ProductUpdateException extends RuntimeException{

    public ProductUpdateException(){ super("Update Product Error"); }

    public ProductUpdateException(String message){ super(message); }

}
