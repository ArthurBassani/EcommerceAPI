package dev.arthur.EcommerceAPI.controllers;

import dev.arthur.EcommerceAPI.dtos.cart.CartResponseDTO;
import dev.arthur.EcommerceAPI.dtos.productCart.ProductCartRequestDTO;
import dev.arthur.EcommerceAPI.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity<CartResponseDTO> getCart(@PathVariable UUID id){
        CartResponseDTO cartResponseDTO = this.cartService.getCart(id);

        return ResponseEntity.ok(cartResponseDTO);
    }

    @PostMapping("/add-product/{id}")
    public ResponseEntity<CartResponseDTO> addProduct(@PathVariable UUID id,
                                                      @RequestBody ProductCartRequestDTO productCartRequestDTO){
        CartResponseDTO cartResponseDTO = this.cartService.addProduct(id,productCartRequestDTO);

        return ResponseEntity.ok(cartResponseDTO);
    }

    @PostMapping("/remove-product/{id}")
    public ResponseEntity<CartResponseDTO> removeProduct(@PathVariable UUID id,
                                                      @RequestBody ProductCartRequestDTO productCartRequestDTO){
        CartResponseDTO cartResponseDTO = this.cartService.removeProduct(id,productCartRequestDTO);
        return ResponseEntity.ok(cartResponseDTO);
    }

}
