package dev.arthur.EcommerceAPI.repositories;

import dev.arthur.EcommerceAPI.models.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

}
