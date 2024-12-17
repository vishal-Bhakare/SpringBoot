package com.example.repository;

import com.example.dto.WishListDto;
import com.example.entity.User;
import com.example.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailId(String emailId);

}
