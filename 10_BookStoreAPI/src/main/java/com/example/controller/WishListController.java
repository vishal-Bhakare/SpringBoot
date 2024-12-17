package com.example.controller;

import com.example.dto.WishListDto;
import com.example.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishListController {

    @Autowired
     private WishListService service;

    @PostMapping("/addWishList")
    public ResponseEntity<String> addWishList(@RequestBody List<WishListDto> dto){
        return new ResponseEntity<>(service.addWishList(dto), HttpStatus.CREATED);
    }

    @GetMapping("/getWishListByUser/{userId}")
    public ResponseEntity<List<WishListDto>> getWishListByUser(@PathVariable Long userId){
        return new ResponseEntity<>(service.getWishListByUser(userId),HttpStatus.OK);
    }

    @DeleteMapping("/removeFromWishList/{userId}/{bookId}")
    public ResponseEntity<String> removeFromWishList( @PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId) {
        return new ResponseEntity<>(service.removeFromWishList(userId, bookId),HttpStatus.OK);
    }
}
