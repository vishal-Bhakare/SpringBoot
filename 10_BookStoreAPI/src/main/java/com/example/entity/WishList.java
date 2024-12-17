package com.example.entity;

import jakarta.persistence.*;

@Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;


    public WishList() {
    }

    public WishList(Long id, User user, Book book) {
        this.id = id;
        this.user = user;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "WishList{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                '}';
    }
}
