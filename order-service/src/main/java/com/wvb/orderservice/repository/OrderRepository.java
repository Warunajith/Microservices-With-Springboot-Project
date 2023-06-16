package com.wvb.orderservice.repository;

import com.wvb.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {


}
