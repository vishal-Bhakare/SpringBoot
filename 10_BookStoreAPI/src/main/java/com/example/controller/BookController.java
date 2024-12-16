package com.example.controller;

import com.example.dto.BookDto;
import com.example.service.BookSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookSerivce service;

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody BookDto dto) {
        return new ResponseEntity<>(service.addBook(dto), HttpStatus.CREATED);
    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        try {
            BookDto dto = service.getBookById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return new ResponseEntity<>(service.getAllBooks(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBook(@RequestBody BookDto dto, @PathVariable Long id) {
        return new ResponseEntity<>(service.updateBook(dto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteBookById(id), HttpStatus.OK);
    }

    @PutMapping("/ChangeBookQuantity/{id}")
    public ResponseEntity<String> ChangeBookQuantity(@PathVariable Long id,  @RequestParam(name = "quantity") Integer quantity) {
        return new ResponseEntity<>(service.ChangeBookQuantity(id, quantity), HttpStatus.OK);
    }

    @PutMapping("/changeprice/{id}")
    public ResponseEntity<String> changeBookPrice( @PathVariable Long id, @RequestBody Map<String, Double> requestBody) {
        Double price = requestBody.get("bookPrice");
        if (price == null) {
            return new ResponseEntity<>("Price is missing in the request body.", HttpStatus.BAD_REQUEST);
        }
        String result = service.changeBookPrice(id, price);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
