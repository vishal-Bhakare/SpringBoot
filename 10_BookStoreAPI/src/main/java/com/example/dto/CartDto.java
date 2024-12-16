package com.example.dto;

import com.example.entity.Book;
import com.example.entity.User;

public class CartDto {
    private Long cartId;
    private Long userId;
    private Long bookId;
    private String bookName;
    private Integer quantity;
    private Double totalPrice;
    public CartDto() {

    }

    public CartDto(Long cartId, Long bookId, String bookName, Integer quantity, Double totalPrice) {
        this.cartId = cartId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}


