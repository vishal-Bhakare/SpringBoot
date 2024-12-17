package com.example.controller;

import com.example.dto.FeedbackDto;
import com.example.entity.Feedback;
import com.example.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/add")
    public String addFeedback(@RequestBody FeedbackDto feedbackDto) {
        return feedbackService.addFeedback(feedbackDto);
    }

    @GetMapping("/getbook/{bookId}")
    public List<Feedback> getFeedbackByBook(@PathVariable Long bookId) {
        return feedbackService.getFeedbackByBook(bookId);
    }

    @GetMapping("/user/{userId}")
    public List<Feedback> getFeedbackByUser(@PathVariable Long userId) {
        return feedbackService.getFeedbackByUser(userId);
    }
}
