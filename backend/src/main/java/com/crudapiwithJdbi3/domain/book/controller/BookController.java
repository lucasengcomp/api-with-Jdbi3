package com.crudapiwithJdbi3.domain.book.controller;

import com.crudapiwithJdbi3.domain.book.entitie.Book;
import com.crudapiwithJdbi3.domain.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService entityService;

    public BookController(BookService entityService) {
        this.entityService = entityService;
    }

    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        log.debug("Request to save Book : {}", book);
        return new ResponseEntity<>(entityService.create(book), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBook() {
        log.debug("Request to get all books");
        return new ResponseEntity<>(entityService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> getOneBook(@PathVariable("id") Long id) {
        log.debug("REST request to get book : {}", id);
        return new ResponseEntity<>(entityService.getOne(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> update(@PathVariable("id") @RequestBody Book book) {
        log.debug("Request to update Book : {}", book);
        return new ResponseEntity<>(entityService.update(book), HttpStatus.OK);
    }
}
