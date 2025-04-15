package dev.arthur.EcommerceAPI.controllers;

import dev.arthur.EcommerceAPI.dtos.product.ProductRequestDTO;
import dev.arthur.EcommerceAPI.dtos.product.ProductResponseDTO;
import dev.arthur.EcommerceAPI.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
            List<ProductResponseDTO> productResponseDTOS = this.productService.findAll();
            return ResponseEntity.ok(productResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable UUID id){
        ProductResponseDTO productResponseDTO = this.productService.getProduct(id);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO = this.productService.createProduct(productRequestDTO);
        //TODO: UPDATE OK TO CREATED
        return ResponseEntity.ok(productResponseDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updatePartialProduct(@PathVariable UUID id,
                                                                    @RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO productResponseDTO = this.productService.updatePartialProduct(id, productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateAllProduct(@PathVariable UUID id,
                                                               @RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO = this.productService.updateAllProduct(id,productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }
}
