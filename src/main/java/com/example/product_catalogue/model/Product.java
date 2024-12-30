package com.example.product_catalogue.model;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 10, max = 10, message = "Code must be exactly 10 characters")
    @Column(nullable = false, unique = true, length = 10)
    private String code;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true, message = "Price in EUR must be greater than or equal to 0")
    @Column(nullable = false)
    private Double priceEur;

    @NotNull
    @Column(nullable = false)
    private Boolean isAvailable;
}
