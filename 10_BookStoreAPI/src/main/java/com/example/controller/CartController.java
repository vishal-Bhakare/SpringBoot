package com.example.controller;

import com.example.dto.CartDto;
import com.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService service;

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestBody CartDto dto) {
        return new ResponseEntity<>(service.addToCart(dto.getUserId(), dto.getBookId(), dto.getQuantity()), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long id) {
        return new ResponseEntity<>(service.removeFromCart(id), HttpStatus.OK);
    }

    @DeleteMapping("/removeuser/{id}")
    public ResponseEntity<String> removeByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(service.removeByUserId(id), HttpStatus.OK);
    }

    @PatchMapping("/updateQuantity/{cartId}")
    public ResponseEntity<String> updateCartQuantity(@PathVariable Long cartId, @RequestBody Map<String, Integer> requestBody) {
        Integer quantity = requestBody.get("quantity");
        if (quantity == null) {
            throw new RuntimeException("Quantity is missing in the request body.");
        }
        String response = service.updateQuantity(cartId, quantity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllCartItemsForUsers/{id}")
    public ResponseEntity<List<CartDto>> getAllCartItemsForUsers(@PathVariable Long id){
        return new ResponseEntity<>(service.getAllCartItemsForUsers(id),HttpStatus.OK);
    }

    @GetMapping("/getAllCartItems")
    public ResponseEntity<List<CartDto>> getAllCartItems(){
        return new ResponseEntity<>(service.getAllCartItems(),HttpStatus.OK);
    }

}
