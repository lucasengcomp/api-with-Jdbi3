package com.crudapiwithJdbi3.domain.author.service.interfaces;

import com.crudapiwithJdbi3.core.exception.service.ResourceNotFoundException;
import com.crudapiwithJdbi3.domain.author.entitie.Author;
import com.crudapiwithJdbi3.domain.author.repository.AuthorRepository;
import com.crudapiwithJdbi3.domain.author.service.AuthorService;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.MessageFormat;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    public AuthorServiceImpl(Jdbi jdbi) {
        this.repository = jdbi.onDemand(AuthorRepository.class);
    }

    @Override
    public Author create(Author author) {
        return getOne(repository.insert(author));
    }

    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }

    @Override
    public Author getOne(long id) {
        ObjectUtils.isEmpty(repository.findById(id));
        throw new ResourceNotFoundException(MessageFormat.format("Author id not found {0}", String.valueOf(id)));
    }

    @Override
    public int deleteById(long id) {
        return repository.deleteById(id);
    }
}
