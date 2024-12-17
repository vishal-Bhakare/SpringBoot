package com.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    private Integer rating;
    private String comment;
    private LocalDateTime timestamp;


    public Feedback() {

    }

    public Feedback(Long id, User user, Book book, Integer rating, String comment, LocalDateTime timestamp) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.rating = rating;
        this.comment = comment;
        this.timestamp = timestamp;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

