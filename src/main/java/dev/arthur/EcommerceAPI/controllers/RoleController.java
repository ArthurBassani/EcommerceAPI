package dev.arthur.EcommerceAPI.controllers;

import dev.arthur.EcommerceAPI.models.role.RoleDeletedDTO;
import dev.arthur.EcommerceAPI.models.role.RoleRequestDTO;
import dev.arthur.EcommerceAPI.models.role.RoleResponseDTO;
import dev.arthur.EcommerceAPI.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles(){
        List<RoleResponseDTO> rolesDTO = this.roleService.findAllRoles();
        return ResponseEntity.ok(rolesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> getRole(@PathVariable UUID id){
        RoleResponseDTO roleResponseDTO = this.roleService.findById(id);
        return ResponseEntity.ok(roleResponseDTO);
    }

    @PostMapping
    public ResponseEntity<RoleResponseDTO> createRole(@RequestBody RoleRequestDTO roleDTO){
        RoleResponseDTO roleResponseDTO = this.roleService.createRole(roleDTO);
        return ResponseEntity.ok(roleResponseDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> partialUpdateRole(@PathVariable UUID id, @RequestBody RoleRequestDTO roleDTO){
        RoleResponseDTO roleResponseDTO = this.roleService.partialUpdateRole(id,roleDTO);
        return ResponseEntity.ok(roleResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> updateAllRole(@PathVariable UUID id, @RequestBody RoleRequestDTO roleRequestDTO){
        RoleResponseDTO roleResponseDTO = this.roleService.updateAllRole(id,roleRequestDTO);
        return ResponseEntity.ok(roleResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoleDeletedDTO> deleteRole(@PathVariable UUID id){
        RoleDeletedDTO roleDeletedDTO = this.roleService.deleteRole(id);
        return ResponseEntity.ok(roleDeletedDTO);
    }


}
