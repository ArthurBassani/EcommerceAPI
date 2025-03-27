package dev.arthur.EcommerceAPI.repositories;

import dev.arthur.EcommerceAPI.models.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SaleRepository extends JpaRepository<Sale, UUID> {

}
