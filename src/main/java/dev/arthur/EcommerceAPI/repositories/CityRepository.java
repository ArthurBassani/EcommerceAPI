package dev.arthur.EcommerceAPI.repositories;

import dev.arthur.EcommerceAPI.models.city.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
    public City findCityByCep(BigInteger cep);
}
