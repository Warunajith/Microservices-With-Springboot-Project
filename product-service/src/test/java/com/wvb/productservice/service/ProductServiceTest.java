package com.wvb.productservice.service;

import com.wvb.productservice.dto.ProductRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    void shouldCreateProduct() throws Exception {

	ProductRequest productRequest= getProductRequest();
        Mockito.verify(productRequest)


	}

    @Test
    void getAllProducts() {

    }

    private ProductRequest getProductRequest(){

		 return ProductRequest.builder()
				 .name("iphone 13")
				 .description("iphone 13")
				 .price(BigDecimal.valueOf(1200))
				 .build();

	}
}