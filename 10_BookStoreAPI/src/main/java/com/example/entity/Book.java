package com.example.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookName;
    private String bookAuthor;
    private String bookDescriptions;
    private String bookLogo;
    private Double bookPrice;
    private Integer bookQuantity;
    public Book() {

    }
    public Book(Long bookId, String bookName, String bookAuthor, String bookDescriptions, String bookLogo,Double bookPrice, Integer bookQuantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescriptions = bookDescriptions;
        this.bookLogo = bookLogo;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookDescriptions='" + bookDescriptions + '\'' +
                ", bookLogo='" + bookLogo + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookQuantity=" + bookQuantity +
                '}';
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookLogo() {
        return bookLogo;
    }

    public void setBookLogo(String bookLogo) {
        this.bookLogo = bookLogo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDescriptions() {
        return bookDescriptions;
    }

    public void setBookDescriptions(String bookDescriptions) {
        this.bookDescriptions = bookDescriptions;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

}
