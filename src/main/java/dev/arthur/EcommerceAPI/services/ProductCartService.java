package dev.arthur.EcommerceAPI.services;

import dev.arthur.EcommerceAPI.models.productCart.ProductCart;
import dev.arthur.EcommerceAPI.repositories.ProductCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductCartService {
    @Autowired
    ProductCartRepository productCartRepository;

}
