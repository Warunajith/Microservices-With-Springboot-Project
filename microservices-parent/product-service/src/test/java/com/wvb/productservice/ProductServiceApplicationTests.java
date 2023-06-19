package com.wvb.productservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wvb.productservice.dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.Socket;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@RequiredArgsConstructor
class ProductServiceApplicationTests {





//	@Container
//	static MongoDBContainer mongoDBContainer= new MongoDBContainer("mongo:4.4.2");
//
//	@BeforeAll
//	static void initAll(){
//		mongoDBContainer.start();
//	}
//
//	@Test
//	void containerStartsAndPublicPortIsAvailable() {
//
//
//		assertThatPortIsAvailable(mongoDBContainer);
//	}
////
////
////
//	private void assertThatPortIsAvailable(MongoDBContainer mongoDBContainer) {
//		try {
//			new Socket(mongoDBContainer.getHost(), mongoDBContainer.getFirstMappedPort());
//		} catch (IOException e) {
//			throw new AssertionError("The expected port " + mongoDBContainer.getFirstMappedPort() + " is not available!");
//		}
	}


//
//	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//	@Autowired
//	private MockMvc mockMvc;
//
//	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//	@Autowired
//	private ObjectMapper objectMapper;
//
//	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry, String databaseName) {
//		dynamicPropertyRegistry.add("spring.data.mongo.uri", () -> {
//			String replicaSetUrl = mongoDBContainer.getReplicaSetUrl();
//			return replicaSetUrl + "/" + "product-service";
//		});
//	}
//
//	@Test
//	void shouldCreateProduct() throws Exception {
//
//		ProductRequest productRequest= getProductRequest();
//		String productRequestString =objectMapper.writeValueAsString(productRequest);
//
//
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/product/createProduct")
//				.contentType(MediaType.APPLICATION_JSON)
//				 .content(productRequestString))
//				.andExpect(status().isCreated());
//
//
//
//	}
//
//
//
//	private ProductRequest getProductRequest(){
//		 return ProductRequest.builder()
//				 .name("iphone 13")
//				 .description("iphone 13")
//				 .price(BigDecimal.valueOf(1200))
//				 .build();
//
//	}
//}
