package com.example.dto;

public class BookDto {
    private String bookName;
    private String bookAuthor;
    private String bookDescriptions;
    private String bookLogo;
    private Double bookPrice;
    private Integer bookQuantity;

    public BookDto() {
    }

    public BookDto(String bookName, String bookAuthor, String bookDescriptions, String bookLogo,Double bookPrice, Integer bookQuantity) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescriptions = bookDescriptions;
        this.bookLogo = bookLogo;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookDescriptions='" + bookDescriptions + '\'' +
                ", bookLogo='" + bookLogo + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookQuantity=" + bookQuantity +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookLogo() {
        return bookLogo;
    }

    public void setBookLogo(String bookLogo) {
        this.bookLogo = bookLogo;
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
