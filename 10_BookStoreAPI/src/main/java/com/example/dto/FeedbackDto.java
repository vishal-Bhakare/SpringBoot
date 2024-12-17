package com.example.dto;

public class FeedbackDto {

    private Long userId;
    private Long bookId;
    private Integer rating;
    private String comment;

    public FeedbackDto() {

    }

    public FeedbackDto(Long userId, Long bookId, Integer rating, String comment) {
        this.userId = userId;
        this.bookId = bookId;
        this.rating = rating;
        this.comment = comment;
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

    @Override
    public String toString() {
        return "FeedbackDto{" +
                "userId=" + userId +
                ", bookId=" + bookId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
