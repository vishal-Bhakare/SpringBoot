package com.example.serviceImpl;

import com.example.dto.BookDto;
import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.service.BookSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookSerivce {

    @Autowired
    private BookRepository repo;

    @Override
    public String addBook(BookDto dto) {
        String str = "";
        if (dto == null) {
            str = "Enter All Fields....";
        }
        try {
            Book book = convertToEntity(dto);
            repo.save(book);
            str = "Book Store SuccessFully......";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return str;
    }

    @Override
    public BookDto getBookById(Long id) {
        Optional<Book> book = repo.findById(id);
        if (book.isPresent()) {
            Book book1 = book.get();
            return convertToDto(book1);
        } else {
            throw new RuntimeException("Book Not Found..." + id);
        }
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = repo.findAll();
        return books.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public String updateBook(BookDto dto, Long id) {
        String str = "";
        Optional<Book> book = repo.findById(id);
        if (book.isPresent()) {
            Book bk = book.get();
            bk.setBookName(dto.getBookName());
            bk.setBookAuthor(dto.getBookAuthor());
            bk.setBookDescriptions(dto.getBookDescriptions());
            bk.setBookLogo(dto.getBookLogo());
            bk.setBookPrice(dto.getBookPrice());
            bk.setBookQuantity(dto.getBookQuantity());
            repo.save(bk);
            str = "Book Updated SuccessFully....";
        } else {
            str = "Book Are Not Found At ID : " + id;
        }
        return str;
    }

    @Override
    public String deleteBookById(Long id) {
        String str = "";
        Optional<Book> book = repo.findById(id);
        if (book.isPresent()) {
            repo.deleteById(id);
            str = "Book Deleted SuccessFully..." + id;
        } else {
            str = "Book Not Found At ID : " + id;
        }
        return str;
    }

    @Override
    public String ChangeBookQuantity(Long id, Integer quantity) {
        Optional<Book> optionalBook = repo.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            Integer currentQuantity = book.getBookQuantity();
            Integer updatedQuantity = currentQuantity + quantity;
            if (updatedQuantity < 0) {
                return "Error: Insufficient stock. Current quantity: " + currentQuantity;
            }
            book.setBookQuantity(updatedQuantity);
            repo.save(book);
            return "Book quantity updated successfully. New quantity: " + updatedQuantity;
        } else {
            throw new RuntimeException("Book with ID " + id + " not found.");
        }
    }

    @Override
    public String changeBookPrice(Long id, Double price) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        if (price == null || price <= 0) {
            return "Invalid price. Price must be greater than zero.";
        }
        book.setBookPrice(price);
        repo.save(book);
        return "Book price updated successfully. New price: " + price;
    }

    private Book convertToEntity(BookDto dto) {
        Book bk = new Book();
        bk.setBookName(dto.getBookName());
        bk.setBookAuthor(dto.getBookAuthor());
        bk.setBookDescriptions(dto.getBookDescriptions());
        bk.setBookLogo(dto.getBookLogo());
        bk.setBookPrice(dto.getBookPrice());
        bk.setBookQuantity(dto.getBookQuantity());
        return bk;
    }

    private BookDto convertToDto(Book bk) {
        BookDto dto = new BookDto();
        dto.setBookName(bk.getBookName());
        dto.setBookAuthor(bk.getBookAuthor());
        dto.setBookDescriptions(bk.getBookDescriptions());
        dto.setBookLogo(bk.getBookLogo());
        dto.setBookPrice(bk.getBookPrice());
        dto.setBookQuantity(bk.getBookQuantity());
        return dto;
    }
}
