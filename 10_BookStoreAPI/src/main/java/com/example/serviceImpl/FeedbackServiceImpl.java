package com.example.serviceImpl;

import com.example.dto.FeedbackDto;
import com.example.entity.Feedback;
import com.example.entity.Book;
import com.example.entity.User;
import com.example.repository.FeedbackRepository;
import com.example.repository.BookRepository;
import com.example.repository.UserRepository;
import com.example.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addFeedback(FeedbackDto feedbackDto) {
        User user = userRepository.findById(feedbackDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(feedbackDto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Feedback feedback = new Feedback();
        feedback.setUser(user);
        feedback.setBook(book);
        feedback.setRating(feedbackDto.getRating());
        feedback.setComment(feedbackDto.getComment());
        feedback.setTimestamp(LocalDateTime.now());

        feedbackRepository.save(feedback);
        return "Feedback added successfully!";
    }

    @Override
    public List<Feedback> getFeedbackByBook(Long bookId) {
        return feedbackRepository.findByBookId(bookId);
    }

    @Override
    public List<Feedback> getFeedbackByUser(Long userId) {
        return feedbackRepository.findByUserId(userId);
    }
}
