package dev.arthur.EcommerceAPI.services;

import dev.arthur.EcommerceAPI.exceptions.product.ProductNotFoundException;
import dev.arthur.EcommerceAPI.exceptions.product.ProductUpdateException;
import dev.arthur.EcommerceAPI.models.product.Product;
import dev.arthur.EcommerceAPI.models.product.ProductMapper;
import dev.arthur.EcommerceAPI.dtos.product.ProductRequestDTO;
import dev.arthur.EcommerceAPI.dtos.product.ProductResponseDTO;
import dev.arthur.EcommerceAPI.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductResponseDTO> findAll() {
        List<Product> products = this.productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();

        for (Product product : products){
            ProductResponseDTO productResponseDTO = this.productMapper.entityToResponse(product);
            productResponseDTOS.add(productResponseDTO);
        }

        return productResponseDTOS;
    }

    public Product findById(UUID id){
            return this.productRepository.findById(id)
                    .orElseThrow(ProductNotFoundException::new);
    }

    public ProductResponseDTO getProduct(UUID id) {
        Product product = this.findById(id);
        return this.productMapper.entityToResponse(product);
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = this.productMapper.requestToEntity(productRequestDTO);
        Product savedProduct = this.productRepository.saveAndFlush(product);
        return this.productMapper.entityToResponse(savedProduct);
    }

    public ProductResponseDTO updatePartialProduct(UUID id, ProductRequestDTO productRequestDTO) {
        Product product = this.findById(id);

        String name = productRequestDTO.getName();
        if(name != null){
            product.setName(name);
        }

        String description = productRequestDTO.getDescription();
        if(description != null){
            product.setDescription(description);
        }

        BigDecimal price = productRequestDTO.getPrice();
        if(price != null){
            product.setPrice(price);
        }

        BigInteger stockQuantity = productRequestDTO.getStockQuantity();
        if(stockQuantity != null){
            product.setStockQuantity(stockQuantity);
        }

        product.setUpdatedAt(Instant.now());
        Product updatedProduct = this.productRepository.save(product);
        return this.productMapper.entityToResponse(updatedProduct);
    }

    public ProductResponseDTO updateAllProduct(UUID id, ProductRequestDTO productRequestDTO){
        Product product = this.findById(id);
        Product updatedProduct;
        try {
            product.setName(productRequestDTO.getName());
            product.setDescription(productRequestDTO.getDescription());
            product.setPrice(productRequestDTO.getPrice());
            product.setStockQuantity(productRequestDTO.getStockQuantity());
            product.setUpdatedAt(Instant.now());
            updatedProduct = this.productRepository.save(product);
        } catch (Exception e) {
            throw new ProductUpdateException("Invalid Product Update Request");
        }

        return this.productMapper.entityToResponse(updatedProduct);
    }

}
