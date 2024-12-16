package com.example.service;

import com.example.dto.OrderDto;
import com.example.entity.Order;

import java.util.List;

public interface OrderService {
   public String placeOrder(OrderDto dto);

  public String cancelOrder(Long orderId);

   public List<Order> getAllNonCanceledOrders();

   public List<Order> getAllOrdersForUser(Long userId);
}
