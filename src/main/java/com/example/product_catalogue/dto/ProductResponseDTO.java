package com.example.product_catalogue.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {

    private Long id;
    private String code;
    private String name;
    private Double priceEur;
    private Double priceUsd;
    private Boolean isAvailable;
}
