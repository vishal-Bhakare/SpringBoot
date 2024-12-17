package com.example.repository;

import com.example.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {

    @Query("SELECT f FROM Feedback f WHERE f.book.id = :bookId")
    List<Feedback> findByBookId(@Param("bookId") Long bookId);
    @Query("SELECT f FROM Feedback f WHERE f.user.id = :userId")
    List<Feedback> findByUserId(Long userId);
}
