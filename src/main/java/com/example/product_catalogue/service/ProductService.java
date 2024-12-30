package com.example.product_catalogue.service;
import com.example.product_catalogue.dto.ProductRequestDTO;
import com.example.product_catalogue.dto.ProductResponseDTO;
import com.example.product_catalogue.mapper.ProductMapper;
import com.example.product_catalogue.model.Product;
import com.example.product_catalogue.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = productMapper.toProduct(productRequestDTO);
        product = productRepository.save(product);

        return productMapper.toProductResponseDTO(product);
    }

    public ProductResponseDTO getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return productMapper.toProductResponseDTO(product);
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(productMapper::toProductResponseDTO)
                .collect(Collectors.toList());
    }
}
