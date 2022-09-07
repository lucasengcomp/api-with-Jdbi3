package com.crudapiwithJdbi3.domain.book.service.interfaces;

import com.crudapiwithJdbi3.core.exception.service.ResourceNotFoundException;
import com.crudapiwithJdbi3.domain.book.entitie.Book;
import com.crudapiwithJdbi3.domain.book.respository.BookRepository;
import com.crudapiwithJdbi3.domain.book.service.BookService;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.MessageFormat;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(Jdbi jdbi) {
        this.repository = jdbi.onDemand(BookRepository.class);
    }

    @Override
    public Book create(Book book) {
        return getOne(repository.insert(book));
    }

    @Override
    public List<Book> getAll(){
        return repository.findAll();
    }

    @Override
    public Book getOne(long id) {
        Book book = repository.findById(id);
        if(ObjectUtils.isEmpty(book)){
            throw new ResourceNotFoundException(MessageFormat.format("Book id not found {0}", String.valueOf(id)));
        }
        return book;
    }

    @Override
    public int deleteById(long id) {
        return repository.deleteById(id);
    }

    @Override
    public Book update(Book book) {
        return getOne(repository.update(book));
    }
}
