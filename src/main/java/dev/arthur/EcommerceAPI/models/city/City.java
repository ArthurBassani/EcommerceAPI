package dev.arthur.EcommerceAPI.models.city;


import dev.arthur.EcommerceAPI.models.address.Address;
import dev.arthur.EcommerceAPI.models.state.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "cities")
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private BigInteger cep;
    private String name;

    @OneToMany(mappedBy = "city")
    private Set<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "id_state")
    private State state;
}
