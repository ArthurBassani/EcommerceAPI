package dev.arthur.EcommerceAPI.services;

import dev.arthur.EcommerceAPI.dtos.cart.CartResponseDTO;
import dev.arthur.EcommerceAPI.dtos.productCart.ProductCartRequestDTO;
import dev.arthur.EcommerceAPI.dtos.productCart.ProductCartResponseDTO;
import dev.arthur.EcommerceAPI.exceptions.cart.CartNotFoundException;
import dev.arthur.EcommerceAPI.models.cart.Cart;
import dev.arthur.EcommerceAPI.models.cart.CartMapper;
import dev.arthur.EcommerceAPI.models.product.Product;
import dev.arthur.EcommerceAPI.models.productCart.ProductCartId;
import dev.arthur.EcommerceAPI.models.productCart.ProductCartMapper;
import dev.arthur.EcommerceAPI.models.productCart.ProductCart;
import dev.arthur.EcommerceAPI.repositories.CartRepository;
import dev.arthur.EcommerceAPI.repositories.ProductCartRepository;
import jakarta.persistence.SecondaryTable;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductCartMapper productCartMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartRepository cartRepository;

    public Cart findById(UUID id){
        return this.cartRepository.findById(id)
                .orElseThrow(CartNotFoundException::new);
    }

    public CartResponseDTO getCart(UUID id) {
        Cart cart = this.findById(id);

        List<ProductCartResponseDTO> productCartResponseDTOList = this.productCartMapper
                .entitySetToResponseList(cart.getProductCarts());

        cart.setTotalValue(this.calcTotalValue(cart));

        return this.cartMapper.entityToResponse(cart,productCartResponseDTOList);
    }

    public BigDecimal calcTotalValue(Cart cart){
        BigDecimal totalValue = BigDecimal.ZERO;

        for(ProductCart productCart : cart.getProductCarts()){
            Product product = productCart.getProduct();
            totalValue = totalValue.add(
                    this.calculateValue(product.getPrice(),productCart.getQuantity())
            );
        }

        return totalValue;
    }

    public CartResponseDTO addProduct(UUID id, ProductCartRequestDTO productCartRequestDTO) {
        //TODO: USER CANT ADD A PRODUCT THAT ALMOST IS IN IT
        Cart cart = this.findById(id);

        Set<ProductCart> productCartList = cart.getProductCarts();

        UUID productId = productCartRequestDTO.getProductId();

        ProductCart productCart = productCartList.stream()
                .filter(pc -> pc.getId().getProductId().equals(productId))
                .findFirst().orElse(null);

        if(productCart != null){
            productCart.increaseQuantity(BigInteger.ONE);
        }else{
            Product product = this.productService.findById(productId);
            ProductCartId productCartId = new ProductCartId();
            productCartId.setCartId(product.getId());
            productCartId.setProductId(cart.getId());

            productCart = new ProductCart(
                    productCartId, product,
                    cart, productCartRequestDTO.getQuantity()
            );

            productCartList.add(productCart);
            BigDecimal amount = this.calculateValue(product.getPrice(),productCart.getQuantity());
            this.increaseTotalValue(cart, amount);
       }

        cartRepository.saveAndFlush(cart);
        return this.getCart(id);
    }

    public CartResponseDTO removeProduct(UUID id, ProductCartRequestDTO productCartRequestDTO){
        Cart cart = this.findById(id);

        cart.getProductCarts().removeIf(
                productCart -> productCart.getId()
                        .getProductId().equals(productCartRequestDTO.getProductId())
        );

        cartRepository.saveAndFlush(cart);
        return this.getCart(id);
    }

    public BigDecimal calculateValue(BigDecimal price, BigInteger quantity){
        return price.multiply(new BigDecimal(quantity));
    }

    public void increaseTotalValue(Cart cart, BigDecimal value){
        cart.increaseTotalValue(value);
        this.cartRepository.saveAndFlush(cart);
    }

    public void decreaseTotalValue(Cart cart, BigDecimal value){
        cart.decreaseTotalValue(value);
        this.cartRepository.saveAndFlush(cart);
    }

}
