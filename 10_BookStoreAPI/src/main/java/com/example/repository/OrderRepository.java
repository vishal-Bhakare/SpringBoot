package com.example.repository;

import com.example.entity.Order;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByCancelFalse();
    List<Order> findByUserAndCancelFalse(User user);
}
