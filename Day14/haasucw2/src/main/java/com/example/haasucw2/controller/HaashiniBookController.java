package com.example.cw2.controller;

import com.example.cw2.model.HaashiniBook;
import com.example.cw2.service.HaashiniBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class HaashiniBookController {
    private final HaashiniBookService bookService;

    public HaashiniBookController(HaashiniBookService BookService) {
        this.bookService = BookService;
    }

    @PostMapping
    public ResponseEntity<HaashiniBook> createBook(@RequestBody HaashiniBook Book) {
        HaashiniBook createdBook = bookService.createBook(Book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping
    public ResponseEntity<List<HaashiniBook>> getAllBooks() {
        List<HaashiniBook> Books = bookService.getAllBooks();
        return ResponseEntity.ok(Books);
    }
    @PutMapping("/{bookId}")
    public HaashiniBook updateBookById(@PathVariable Long bookId,@RequestBody HaashiniBook book){
        HaashiniBook b = bookService.updateBookById(bookId, book);
        return b;
    }
    @GetMapping("/{bookId}")
    public HaashiniBook getBookById(@PathVariable Long bookId) {
        HaashiniBook book = bookService.getBookById(bookId);
        return book;
    }
}
