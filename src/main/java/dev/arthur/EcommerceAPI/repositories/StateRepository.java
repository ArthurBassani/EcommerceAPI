package dev.arthur.EcommerceAPI.repositories;

import dev.arthur.EcommerceAPI.models.state.State;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StateRepository extends JpaRepository<State, UUID> {
    public State findStateByAbbreviation(String abbreviation);
}
