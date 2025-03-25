package dev.arthur.EcommerceAPI.models.state;


import dev.arthur.EcommerceAPI.models.city.City;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "states")
@NoArgsConstructor
@AllArgsConstructor
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String abbreviation;

    @OneToMany
    private Set<City> cities;
}
