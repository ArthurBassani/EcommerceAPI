package dev.arthur.EcommerceAPI.services;

import dev.arthur.EcommerceAPI.exceptions.role.RoleAlmostExistsException;
import dev.arthur.EcommerceAPI.exceptions.role.RoleCantBeDeletedException;
import dev.arthur.EcommerceAPI.exceptions.role.RoleNotFoundException;
import dev.arthur.EcommerceAPI.models.role.*;
import dev.arthur.EcommerceAPI.repositories.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleMapper roleMapper;

    public List<RoleResponseDTO> findAllRoles() {
        List<Role> roles = this.roleRepository.findAll();
        List<RoleResponseDTO> roleResponseDTOS = new ArrayList<>();
        for (Role role : roles){
            roleResponseDTOS.add(this.roleMapper.entityToResponse(role));
        }
        return roleResponseDTOS;
    }

    public RoleResponseDTO findById(UUID id) {
        Role role = this.roleRepository.findById(id)
                .orElseThrow(RoleNotFoundException::new);

        return this.roleMapper.entityToResponse(role);

    }

    public RoleResponseDTO createRole(RoleRequestDTO roleDTO){
        if(this.roleRepository.existsByName(roleDTO.getName())){
            //TODO: UPDATE NAME COLUMN ON DATABASE TO NAME BE UNIQUE
            throw new RoleAlmostExistsException();
        }

        Role role = new Role();
        role.setName(roleDTO.getName());

        Role savedRole = this.roleRepository.saveAndFlush(role);
        return this.roleMapper.entityToResponse(savedRole);
    }

    public RoleResponseDTO partialUpdateRole(UUID id, RoleRequestDTO roleDTO) {
            Role role = this.roleRepository.findById(id)
                        .orElseThrow(RoleNotFoundException::new);

            if(roleDTO.getName() != null){
                role.setName(roleDTO.getName());
            }
            role.setUpdatedAt(Instant.now());
            Role updatedRole = this.roleRepository.save(role);
            return this.roleMapper.entityToResponse(updatedRole);
    }

    public RoleResponseDTO updateAllRole(UUID id, RoleRequestDTO roleRequestDTO){
        return this.partialUpdateRole(id,roleRequestDTO);
    }

    public RoleDeletedDTO deleteRole(UUID id) {
        Role role = this.roleRepository.findById(id)
                .orElseThrow(RoleNotFoundException::new);
        try {
            this.roleRepository.delete(role);
        } catch (RuntimeException e) {
            throw new RoleCantBeDeletedException();
        }

        return new RoleDeletedDTO(
                "role " + role.getId() + " deleted",
                role.getName(),
                Instant.now()
        );
    }
}
