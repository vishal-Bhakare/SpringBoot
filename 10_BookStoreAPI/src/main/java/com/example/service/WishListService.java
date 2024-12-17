package com.example.service;

import com.example.dto.WishListDto;

import java.util.List;

public interface WishListService {
   public String addWishList(List<WishListDto> dto);

  public List<WishListDto> getWishListByUser(Long userId);

  public String removeFromWishList(Long userId, Long bookId);
}
