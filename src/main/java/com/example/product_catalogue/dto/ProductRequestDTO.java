package com.example.product_catalogue.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDTO {

    @NotBlank
    @Size(min = 10, max = 10, message = "Code must be exactly 10 characters")
    private String code;

    @NotBlank
    private String name;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true, message = "Price in EUR must be greater than or equal to 0")
    private Double priceEur;

    @NotNull
    private Boolean isAvailable;
}
