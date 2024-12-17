package com.example.repository;

import com.example.entity.User;
import com.example.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long> {
    List<WishList> findByUser(User user);
    @Query("SELECT w FROM WishList w WHERE w.user.id = :userId AND w.book.id = :bookId")
    Optional<WishList> findByUserIdAndBookId(@Param("userId") Long userId, @Param("bookId") Long bookId);

}
