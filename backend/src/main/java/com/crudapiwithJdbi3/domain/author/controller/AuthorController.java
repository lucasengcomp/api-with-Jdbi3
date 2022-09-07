package com.crudapiwithJdbi3.domain.author.controller;

import com.crudapiwithJdbi3.domain.author.entitie.Author;
import com.crudapiwithJdbi3.domain.author.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final Logger log = LoggerFactory.getLogger(AuthorController.class);
    private final AuthorService entityService;

    public AuthorController(AuthorService entityService) {
        this.entityService = entityService;
    }

    @PostMapping()
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        log.debug("Request to save Author : ", author);
        return new ResponseEntity<>(entityService.create(author), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Author>> getAllAuthor() {
        log.debug("Request to get all authors");
        return new ResponseEntity<>(entityService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> getOneAuthor(@PathVariable("id") Long id) {
        log.debug("Request to get one Author by id : ", id);
        return new ResponseEntity<>(entityService.getOne(id), HttpStatus.OK);
    }
}
