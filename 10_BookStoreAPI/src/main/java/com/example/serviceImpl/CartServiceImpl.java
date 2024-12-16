package com.example.serviceImpl;

import com.example.dto.CartDto;
import com.example.entity.Book;
import com.example.entity.Cart;
import com.example.entity.User;
import com.example.repository.BookRepository;
import com.example.repository.CartRepository;
import com.example.repository.UserRepository;
import com.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private BookRepository bookRepo;

    @Override
    public String addToCart(Long userId, Long bookId, Integer quntity) {
        User user = userRepo.findById(userId).orElseThrow(() ->
                new RuntimeException("User Not Found At Id : " + userId));
        Book book = bookRepo.findById(bookId).orElseThrow(() ->
                new RuntimeException("Book Not Found At Id : " + bookId));
        Optional<Cart> existingCart = cartRepo.findByUserAndBook(user, book);
        if (existingCart.isPresent()) {
            Cart cart = existingCart.get();
            cart.setQuntity(cart.getQuntity() + quntity);
            cart.setTotalPrice(cart.getQuntity() * book.getBookPrice());
            cartRepo.save(cart);
            return "Book quantity updated in cart.";
        } else {
            Cart cart = new Cart();
            cart.setUser(user);
            cart.setBook(book);
            cart.setQuntity(quntity);
            cart.setTotalPrice(quntity * book.getBookPrice());
            cartRepo.save(cart);
            return "Book added to cart.";
        }
    }

    @Override
    public String removeFromCart(Long id) {
        return cartRepo.findById(id).map(cart -> {
            cartRepo.delete(cart);
            return "Cart item with ID " + id + " removed successfully.";
        }).orElseThrow(() -> new RuntimeException("Cart item with ID " + id + " not found."));
    }

    @Override
    public String removeByUserId(Long id) {
        if (cartRepo.existsByUserId(id)) {
            throw new RuntimeException("Cannot delete user with active cart items. Remove cart items first.");
        }
        return userRepo.findById(id).map(user -> {
            userRepo.delete(user);
            return "User Removed Successfully At Id : " + id;
        }).orElseThrow(() -> new RuntimeException("User is not found at ID: " + id));
    }

    @Override
    public String updateQuantity(Long cartId, Integer quantity) {
        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart item not found with ID: " + cartId));
        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be greater than zero.");
        }
        cart.setQuntity(quantity);
        cart.setTotalPrice(cart.getBook().getBookPrice() * quantity);
        cartRepo.save(cart);
        return "Cart item quantity updated successfully to: " + quantity;
    }

    @Override
    public List<CartDto> getAllCartItemsForUsers(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User is not Fount At Id : " + id));
        List<Cart> UserCart = cartRepo.findByUser(user);
        return UserCart.stream().map(cart -> new CartDto(
                cart.getCartId(),
                cart.getBook().getBookId(),
                cart.getBook().getBookName(),
                cart.getQuntity(),
                cart.getTotalPrice()
        )).collect(Collectors.toList());
    }

    @Override
    public List<CartDto> getAllCartItems() {
        List<Cart> carts = cartRepo.findAll();
        return carts.stream().map(cart -> new CartDto(
                cart.getCartId(),
                cart.getBook().getBookId(),
                cart.getBook().getBookName(),
                cart.getQuntity(),
                cart.getTotalPrice()
        )).collect(Collectors.toList());
    }


}
