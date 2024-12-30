package com.example.product_catalogue.mapper;

import com.example.product_catalogue.dto.ProductRequestDTO;
import com.example.product_catalogue.dto.ProductResponseDTO;
import com.example.product_catalogue.model.Product;
import com.example.product_catalogue.service.ConversionRateService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    @Autowired
    protected ConversionRateService conversionRateService;

    @Mapping(target = "id", ignore = true)
    public abstract Product toProduct(ProductRequestDTO dto);

    @Mapping(target = "priceUsd", source = "priceEur", qualifiedByName = "convertToUsd")
    public abstract ProductResponseDTO toProductResponseDTO(Product product);

    @Named("convertToUsd")
    public Double convertToUsd(Double priceEur) {
        if (priceEur == null) {
            return null;
        }
        double conversionRate = conversionRateService.getConversionRate();
        return priceEur * conversionRate;
    }
}