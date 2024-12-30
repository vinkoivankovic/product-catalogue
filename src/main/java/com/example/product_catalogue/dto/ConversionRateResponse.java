package com.example.product_catalogue.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversionRateResponse {

    @JsonProperty("srednji_tecaj")
    private String rate;
}