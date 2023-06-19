package com.wvb.orderservice.service;

import com.wvb.orderservice.dto.InventoryResponse;
import com.wvb.orderservice.dto.OrderLineItemsDto;
import com.wvb.orderservice.dto.OrderRequest;
import com.wvb.orderservice.model.Order;
import com.wvb.orderservice.model.OrderLineItems;
import com.wvb.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;
    private  final WebClient webClient;


    public void placeOrder(OrderRequest orderRequest){

        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

        order.setOrderLineItems(orderLineItems);

        List<String> skuCodes= order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode)
                .collect(Collectors.toList());


        //Call the Inventory Service and Place order if product is in stock
      InventoryResponse[] inventoryResponseArray =  webClient.get()
                .uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();//make it synchronus by using block

      boolean allProductsInStock = Arrays.stream(inventoryResponseArray)
              .allMatch(InventoryResponse::isInStock);

      if(allProductsInStock){
          orderRepository.save(order);
      }else{
          throw new IllegalArgumentException("product is not in stock,please try again later");
      }



    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {

        OrderLineItems orderLineItems= new OrderLineItems();

        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());

        return orderLineItems;



    }

    }
