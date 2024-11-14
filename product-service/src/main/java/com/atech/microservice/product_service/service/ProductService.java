package com.atech.microservice.product_service.service;

import com.atech.microservice.product_service.dto.ProductRequest;
import com.atech.microservice.product_service.dto.ProductResponse;
import com.atech.microservice.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.atech.microservice.product_service.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product Created Successfully.");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }


    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
