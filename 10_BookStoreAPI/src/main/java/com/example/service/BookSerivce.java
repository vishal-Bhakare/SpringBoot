package com.example.service;

import com.example.dto.BookDto;

import java.util.List;

public interface BookSerivce {
   public String addBook(BookDto dto);

    public BookDto getBookById(Long id);

    public List<BookDto> getAllBooks();

    public String updateBook(BookDto dto,Long id);

    public String deleteBookById(Long id);

    public String ChangeBookQuantity(Long id, Integer quntity);

    public String changeBookPrice(Long id, Double price);
}
