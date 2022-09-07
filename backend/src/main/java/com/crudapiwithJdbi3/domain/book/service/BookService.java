package com.crudapiwithJdbi3.domain.book.service;

import com.crudapiwithJdbi3.domain.book.entitie.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    List<Book> getAll();

    Book getOne(long id);

    int deleteById(long id);

    Book update(Book book);
}
