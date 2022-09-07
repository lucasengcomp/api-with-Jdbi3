package com.crudapiwithJdbi3.domain.author.service;

import com.crudapiwithJdbi3.domain.author.entitie.Author;

import java.util.List;

public interface AuthorService {

    Author create(Author author);

    List<Author> getAll();

    Author getOne(long id);

    int deleteById(long id);
}
