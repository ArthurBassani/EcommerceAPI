package dev.arthur.EcommerceAPI.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.arthur.EcommerceAPI.models.address.Address;
import dev.arthur.EcommerceAPI.models.cart.Cart;
import dev.arthur.EcommerceAPI.models.favorite.Favorite;
import dev.arthur.EcommerceAPI.models.role.Role;
import dev.arthur.EcommerceAPI.models.sale.Sale;
import dev.arthur.EcommerceAPI.models.shop.Shop;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String document;
    private String email;
    private String password;
    private String phone;
    private Date birthdate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties()
    private Favorite favorite;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany
    private Set<Sale> sales;

    @OneToMany
    private Set<Shop> shopping;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "user_addresses",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_address")
    )
    private Set<Address> addresses;

}
