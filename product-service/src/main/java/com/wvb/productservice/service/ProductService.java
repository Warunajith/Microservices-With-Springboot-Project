package com.wvb.productservice.service;

import com.wvb.productservice.dto.ProductRequest;
import com.wvb.productservice.dto.ProductResponse;
import com.wvb.productservice.model.Product;
import com.wvb.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){

        Product product= Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product"+product.getId()+" is saved");

    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products=productRepository.findAll();

        return products.stream().map(product -> mapToProductResponse(product)).collect(Collectors.toList());

    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
