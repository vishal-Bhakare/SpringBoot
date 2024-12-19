package com.example.serviceImpl;

import com.example.dto.OrderDto;
import com.example.entity.Book;
import com.example.entity.Order;
import com.example.entity.User;
import com.example.repository.BookRepository;
import com.example.repository.OrderRepository;
import com.example.repository.UserRepository;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private BookRepository bookRepo;

    @Override
    public String placeOrder(OrderDto orderDto) {
        User user = userRepo.findById(orderDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + orderDto.getUserId()));

        Book book = bookRepo.findAll().stream()
                .filter(b -> b.getBookQuantity() > 0)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No books available in stock"));

        if (book.getBookQuantity() < orderDto.getQuantity()) {
            throw new RuntimeException("Insufficient stock for the book: " + book.getBookName());
        }
        book.setBookQuantity(book.getBookQuantity() - orderDto.getQuantity());
        bookRepo.save(book);
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setQuantity(orderDto.getQuantity());
        order.setAddress(orderDto.getAddress());
        order.setUser(user);
        order.setBook(book);
        order.setCancel(false);
        orderRepo.save(order);
        return "Order placed successfully for Book: " + book.getBookName();
    }
  /* @Override
    public String placeOrder(OrderDto orderDto) {
        User user = userRepo.findById(orderDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + orderDto.getUserId()));

        Book book = bookRepo.findById(orderDto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + orderDto.getBookId()));

        if (book.getBookQuantity() < orderDto.getQuantity()) {
            throw new RuntimeException("Insufficient stock for the book: " + book.getBookName());
        }
        book.setBookQuantity(book.getBookQuantity() - orderDto.getQuantity());
        bookRepo.save(book);
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setQuantity(orderDto.getQuantity());
        order.setAddress(orderDto.getAddress());
        order.setUser(user);
        order.setBook(book);
        order.setCancel(false);
        orderRepo.save(order);
        return "Order placed successfully for Book: " + book.getBookName();
    }*/

    @Override
    public String cancelOrder(Long orderId) {
        return orderRepo.findById(orderId).map(order -> {
            if (order.getCancel() != null && order.getCancel()) {
                throw new RuntimeException("Order is already cancelled for Order ID: " + orderId);
            }
            order.setCancel(true);
            orderRepo.save(order);
            return "Order canceled successfully for Order ID: " + orderId;
        }).orElseThrow(() -> new RuntimeException("Order not found for ID: " + orderId));
    }

    @Override
    public List<Order> getAllNonCanceledOrders() {
        return orderRepo.findByCancelFalse();
    }

    @Override
    public List<Order> getAllOrdersForUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found for ID: " + userId));
        return orderRepo.findByUserAndCancelFalse(user);
    }
}
