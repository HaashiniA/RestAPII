package com.example.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.HaashiniAuthor;
import com.example.q1.repository.HaashiniAuthorRepository;

@Service
public class HaashiniAuthorService {
    @Autowired
    private HaashiniAuthorRepository authorRepository;

    public HaashiniAuthor saveAuthor(HaashiniAuthor author) {
        return authorRepository.save(author);
    }

    public HaashiniAuthor getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<HaashiniAuthor> getAllAuthors() {
        return authorRepository.findAll();
    }

    public HaashiniAuthor updateAuthor(Long id, HaashiniAuthor author) {
        HaashiniAuthor existingAuthor = authorRepository.findById(id).orElse(null);
        if (existingAuthor != null) {
            existingAuthor.setEmail(author.getEmail());
            existingAuthor.setPhoneNumber(author.getPhoneNumber());
            existingAuthor.setAddress(author.getAddress());
            return authorRepository.save(existingAuthor);
        }
        return null;
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
