package com.example.entity;


import jakarta.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;
    private Integer quntity;
    private Double totalPrice;

    public Cart() {
    }

    public Cart(Long cartId, User user, Book book, Integer quntity, Double totalPrice) {
        this.cartId = cartId;
        this.user = user;
        this.book = book;
        this.quntity = quntity;
        this.totalPrice = totalPrice;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuntity() {
        return quntity;
    }

    public void setQuntity(Integer quntity) {
        this.quntity = quntity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", user=" + user +
                ", book=" + book +
                ", quntity=" + quntity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
