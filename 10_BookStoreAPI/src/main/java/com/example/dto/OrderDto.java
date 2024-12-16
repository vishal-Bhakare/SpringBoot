package com.example.dto;

public class OrderDto {

    private Long userId;
    private Long bookId;
    private Integer quantity;
    private String address;

    public OrderDto() {
    }

    public OrderDto(Long userId, Long bookId, Integer quantity, String address) {
        this.userId = userId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.address = address;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "userId=" + userId +
                ", bookId=" + bookId +
                ", quantity=" + quantity +
                ", address='" + address + '\'' +
                '}';
    }
}
