package dev.arthur.EcommerceAPI.models.user;

import dev.arthur.EcommerceAPI.dtos.user.UserDetailDTO;
import dev.arthur.EcommerceAPI.dtos.user.UserRequestDTO;
import dev.arthur.EcommerceAPI.dtos.user.UserResponseDTO;
import dev.arthur.EcommerceAPI.dtos.user.UserUpdatedDTO;
import dev.arthur.EcommerceAPI.models.cart.Cart;
import dev.arthur.EcommerceAPI.models.favorite.Favorite;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

@Component
public class UserMapper {

    public void updateUserProperties(User user, UserRequestDTO userDTO){

    }

    public User requestToEntity(UserRequestDTO userDTO){
        User user = new User();

        user.setName(userDTO.getName());
        user.setDocument(userDTO.getDocument());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setBirthdate(userDTO.getBirthdate());

        user.setSales(new HashSet<>());
        user.setShopping(new HashSet<>());
        user.setAddresses(new HashSet<>());

        user.setCart(new Cart());
        user.getCart().setUser(user);
        user.getCart().setTotalValue(BigDecimal.ZERO);

        user.setFavorite(new Favorite());
        user.getFavorite().setUser(user);

        return user;
    }

    public UserResponseDTO entityToResponse(User user){
        return new UserResponseDTO(
               user.getId(), user.getName(), user.getEmail()
        );
    }

    public UserDetailDTO entityToDetailResponse(User user){
        return new UserDetailDTO(
                user.getId(), user.getName(),
                user.getDocument(), user.getEmail(),
                user.getPhone(), user.getBirthdate(),
                user.getRole().getId(),user.getFavorite().getId(),
                user.getCart().getId()
        );
    }

    public UserUpdatedDTO entityToUpdatedDTO(User user, List<String> updatedProperties) {
        return new UserUpdatedDTO(
                user.getId(),user.getName(),
                user.getEmail(), updatedProperties
        );
    }
}
