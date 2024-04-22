package com.example.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.HaashiniPerson;
import com.example.springapp.service.HaashiniPersonService;

@RestController
public class HaashiniPersonController {
    public HaashiniPersonService personService;

    public HaashiniPersonController(HaashiniPersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/api/person")
    public ResponseEntity<HaashiniPerson> postMethodName(@RequestBody HaashiniPerson person) {
        if (personService.savePerson(person)) {
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/person/byage/{age}")
    public ResponseEntity<List<HaashiniPerson>> getMethodName(@PathVariable("age") int age) {
        List<HaashiniPerson> list = personService.getPersonByAge(age);
        if (list.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
