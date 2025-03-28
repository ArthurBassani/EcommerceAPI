package dev.arthur.EcommerceAPI.models.sale;

import dev.arthur.EcommerceAPI.models.address.Address;
import dev.arthur.EcommerceAPI.models.productSale.ProductSale;
import dev.arthur.EcommerceAPI.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="sales")
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private ZonedDateTime date;

    @Column(name = "total_value", updatable = false)
    private BigDecimal totalValue;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @ManyToOne
    @JoinTable(name = "id_address")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "sale")
    private Set<ProductSale> productSales;

}
