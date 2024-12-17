package com.example.serviceImpl;

import com.example.dto.WishListDto;
import com.example.entity.Book;
import com.example.entity.User;
import com.example.entity.WishList;
import com.example.repository.BookRepository;
import com.example.repository.UserRepository;
import com.example.repository.WishListRepository;
import com.example.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishListServiceImpl implements WishListService {

    @Autowired
    private WishListRepository wishRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BookRepository bookRepo;

    @Override
    public String addWishList(List<WishListDto> wishlistDtos) {
        wishlistDtos.forEach(dto -> {

            User user = userRepo.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));
            Book book = bookRepo.findById(dto.getBookId())
                    .orElseThrow(() -> new RuntimeException("Book not found with ID: " + dto.getBookId()));

            WishList wishList = new WishList();
            wishList.setUser(user);
            wishList.setBook(book);
            wishRepo.save(wishList);
        });
        return "Books Added To WishList Successfully!";
    }

    @Override
    public List<WishListDto> getWishListByUser(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        List<WishList> wishLists = wishRepo.findByUser(user);
        return wishLists.stream().map(wishList -> {
            WishListDto dto = new WishListDto();
            dto.setUserId(wishList.getUser().getId());
            dto.setBookId(wishList.getBook().getBookId());
            return dto;
        }).toList();
    }

    @Override
    public String removeFromWishList(Long userId, Long bookId) {
        WishList wishList = wishRepo.findByUserIdAndBookId(userId,bookId)
                .orElseThrow(() -> new RuntimeException("WishList entry not found for User ID: "
                        + userId + " and Book ID: " + bookId));
        wishRepo.delete(wishList);
        return "Book removed from WishList successfully.";
    }


}
