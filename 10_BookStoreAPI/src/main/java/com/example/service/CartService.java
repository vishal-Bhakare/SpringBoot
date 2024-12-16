package com.example.service;

import com.example.dto.CartDto;

import java.util.List;

public interface CartService {
    public String addToCart(Long userId, Long bookId, Integer quntity);

    public String removeFromCart(Long id);

    public String removeByUserId(Long id);

    public String updateQuantity(Long id, Integer quantity);

    public List<CartDto> getAllCartItemsForUsers(Long id);

    public List<CartDto> getAllCartItems();
}
