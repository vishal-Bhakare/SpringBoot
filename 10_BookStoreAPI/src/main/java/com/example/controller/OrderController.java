package com.example.controller;


import com.example.dto.OrderDto;
import com.example.entity.Order;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService service;
    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDto dto){
        return new ResponseEntity<>(service.placeOrder(dto), HttpStatus.OK);
    }

    @PostMapping("/cancelOrder/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long orderId) {
        String response = service.cancelOrder(orderId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>> getAllNonCanceledOrders() {
        List<Order> orders = service.getAllNonCanceledOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @GetMapping("/getOrdersForUser/{userId}")
    public ResponseEntity<List<Order>> getAllOrdersForUser(@PathVariable Long userId) {
        List<Order> orders = service.getAllOrdersForUser(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
