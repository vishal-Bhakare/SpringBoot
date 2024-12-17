package com.example.dto;

import com.example.entity.Book;
import com.example.entity.User;

public class WishListDto {

    private Long userId;
    private Long bookId;
    private User user;
    private Book book;

    public WishListDto() {

    }

    public WishListDto(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    public Long getBookId() {

        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        return "WishListDto{" +
                "user=" + user +
                ", book=" + book +
                '}';
    }


}
