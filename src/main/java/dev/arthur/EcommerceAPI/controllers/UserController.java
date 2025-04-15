package dev.arthur.EcommerceAPI.controllers;

import dev.arthur.EcommerceAPI.dtos.user.UserDetailDTO;
import dev.arthur.EcommerceAPI.dtos.user.UserRequestDTO;
import dev.arthur.EcommerceAPI.dtos.user.UserResponseDTO;
import dev.arthur.EcommerceAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        List<UserResponseDTO> userResponseDTOS = this.userService.findAll();
        return ResponseEntity.ok(userResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable UUID id){
        UserResponseDTO userResponse = this.userService.findById(id);

        return ResponseEntity.ok(userResponse);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<UserDetailDTO> getDetailUser(@PathVariable UUID id){
        UserDetailDTO userDetailDTO = this.userService.getDetailUser(id);

        return ResponseEntity.ok(userDetailDTO);
    }


    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userDTO) throws Exception {
        UserResponseDTO userResponse = userService.createUser(userDTO);
        //TODO: PUT RESPONSE AS CREATED
        return ResponseEntity.ok(userResponse);
    }
}
