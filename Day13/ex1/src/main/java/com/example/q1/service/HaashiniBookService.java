package com.example.q1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.HaashiniAuthor;
import com.example.q1.model.HaashiniBook;
import com.example.q1.repository.HaashiniAuthorRepository;
import com.example.q1.repository.HaashiniBookRepository;

@Service
public class HaashiniBookService {
    @Autowired
    private HaashiniBookRepository bookRepository;
@Autowired
private HaashiniAuthorRepository authorRepository;
    public HaashiniBook saveBook(Long authorId, HaashiniBook book) {
        HaashiniAuthor author = authorRepository.findById(authorId).orElse(null);
        if (author != null) {
            book.setAuthor(author);
            author.getBooks().add(book);
            return bookRepository.save(book);
        }
        return null;
    }

    public HaashiniBook getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

