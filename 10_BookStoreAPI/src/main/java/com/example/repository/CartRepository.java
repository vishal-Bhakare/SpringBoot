package com.example.repository;

import com.example.entity.Book;
import com.example.entity.Cart;
import com.example.entity.User;
import com.example.service.CartService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Optional<Cart> findByUserAndBook(User user, Book book);
    boolean existsByUserId(Long userId);
    List<Cart> findByUser(User user);
}

