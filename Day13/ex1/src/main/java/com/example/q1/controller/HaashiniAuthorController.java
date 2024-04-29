package com.example.q1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.q1.model.HaashiniAuthor;
import com.example.q1.model.HaashiniBook;
import com.example.q1.service.HaashiniAuthorService;
import com.example.q1.service.HaashiniBookService;

@RestController
public class HaashiniAuthorController {
    @Autowired
    private HaashiniAuthorService authorService;
@Autowired
private HaashiniBookService bookService;
    @PostMapping("/author")
    public ResponseEntity<HaashiniAuthor> createAuthor(@RequestBody HaashiniAuthor author) {
        HaashiniAuthor savedAuthor = authorService.saveAuthor(author);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

    @PostMapping("/book/author/{authorId}")
    public ResponseEntity<HaashiniBook> createBookForAuthor(@PathVariable Long authorId, @RequestBody HaashiniBook book) {
        HaashiniBook savedBook = bookService.saveBook(authorId, book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<HaashiniAuthor> getAuthorById(@PathVariable Long authorId) {
        HaashiniAuthor author = authorService.getAuthorById(authorId);
        if (author != null) {
            return new ResponseEntity<>(author, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/author")
    public ResponseEntity<List<HaashiniAuthor>> getAllAuthors() {
        List<HaashiniAuthor> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PutMapping("/author/{authorId}")
    public ResponseEntity<HaashiniAuthor> updateAuthor(@PathVariable Long authorId, @RequestBody HaashiniAuthor author) {
        HaashiniAuthor updatedAuthor = authorService.updateAuthor(authorId, author);
        if (updatedAuthor != null) {
            return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
    }
}
