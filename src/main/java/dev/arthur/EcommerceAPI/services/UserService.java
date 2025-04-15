package dev.arthur.EcommerceAPI.services;

import dev.arthur.EcommerceAPI.dtos.user.UserDetailDTO;
import dev.arthur.EcommerceAPI.dtos.user.UserRequestDTO;
import dev.arthur.EcommerceAPI.dtos.user.UserResponseDTO;
import dev.arthur.EcommerceAPI.dtos.user.UserUpdatedDTO;
import dev.arthur.EcommerceAPI.models.role.Role;
import dev.arthur.EcommerceAPI.models.user.*;
import dev.arthur.EcommerceAPI.repositories.CartRepository;
import dev.arthur.EcommerceAPI.repositories.FavoriteRepository;
import dev.arthur.EcommerceAPI.repositories.RoleRepository;
import dev.arthur.EcommerceAPI.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    FavoriteRepository favoriteRepository;

    @Autowired
    CartRepository cartRepository;

    public UserResponseDTO findById(UUID id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        return this.userMapper.entityToResponse(user);
    }

    public UserResponseDTO createUser(UserRequestDTO userDTO) throws Exception {
        if (userDTO.getRoleId() == null) {
            throw new RuntimeException("roleId Expected");
        }

        Role role = this.roleRepository.findById(userDTO.getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));

        User user = this.userMapper.requestToEntity(userDTO);

        user.setRole(role);

        User savedUser = this.userRepository.save(user);
        return this.userMapper.entityToResponse(savedUser);
    }

    public UserUpdatedDTO partialUpdateUser(UUID id, UserRequestDTO userDTO) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        List<String> updatedProperties = new ArrayList<>() {
        };

        if (userDTO.getName() != null) {
            user.setName(userDTO.getName());
            updatedProperties.add("Name");
        }

        if (userDTO.getDocument() != null) {
            user.setDocument(userDTO.getDocument());
            updatedProperties.add("Document");
        }

        if (userDTO.getPhone() != null) {
            user.setPhone(userDTO.getPhone());
            updatedProperties.add("Phone");
        }

        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
            updatedProperties.add("Email");
        }

        if (userDTO.getPassword() != null) {
            user.setPassword(userDTO.getPassword());
            updatedProperties.add("Password");
        }

        if (userDTO.getBirthdate() != null) {
            user.setBirthdate(userDTO.getBirthdate());
            updatedProperties.add("Birthdate");
        }

        if (userDTO.getRoleId() != null) {
            Role role = this.roleRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Role not found"));
            user.setRole(role);
            updatedProperties.add("Role");
        }

        return this.userMapper.entityToUpdatedDTO(user, updatedProperties);
    }

    public List<UserResponseDTO> findAll() {
        List<User> users = this.userRepository.findAll();
        List<UserResponseDTO> responseDTOS = new ArrayList<>();

        for (User user : users){
            UserResponseDTO response = this.userMapper.entityToResponse(user);
            responseDTOS.add(response);
        }

        return responseDTOS;
    }

    public UserDetailDTO getDetailUser(UUID id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        return this.userMapper.entityToDetailResponse(user);
    }
}
