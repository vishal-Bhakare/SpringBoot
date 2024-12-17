package com.example.service;

import com.example.dto.FeedbackDto;
import com.example.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    String addFeedback(FeedbackDto feedbackDto);

    List<Feedback> getFeedbackByBook(Long bookId);

    List<Feedback> getFeedbackByUser(Long userId);
}
