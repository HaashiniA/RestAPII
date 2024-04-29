package com.example.cw2.service;

import com.example.cw2.model.HaashiniBook;
import com.example.cw2.repository.HaashiniBookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HaashiniBookService {
    private final HaashiniBookRepo bookRepo;

    public HaashiniBookService(HaashiniBookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public HaashiniBook createBook(HaashiniBook Book) {
        return bookRepo.save(Book);
    }
    public List<HaashiniBook> getAllBooks() {
        return bookRepo.findAll();
    }
    public HaashiniBook getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }
    public HaashiniBook updateBookById(Long id,HaashiniBook book){
        HaashiniBook b = bookRepo.findById(id).orElse(null);
        if(b!=null){
            b.setAuthor(book.getAuthor());
            b.setAvailableCopies(book.getAvailableCopies());
            b.setTitle(book.getTitle());
            b.setTotalCopies(book.getTotalCopies());
            bookRepo.save(b);
        }
        return b;
    }
}
