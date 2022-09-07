package com.crudapiwithJdbi3.domain.author.repository;

import com.crudapiwithJdbi3.domain.author.entitie.Author;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RegisterBeanMapper(Author.class)
public interface AuthorRepository {

    @SqlQuery("SELECT * FROM author;")
    List<Author> findAll();

    @SqlQuery("SELECT * FROM author" +
            "WHERE id = :id;")
    Author findById(@Bind("id") long id);

    @Transaction
    @SqlUpdate("DELETE FROM author " +
            "WHERE id = :id;")
    int deleteById(@Bind("id") long id);

    @Transaction
    @SqlUpdate(" UPDATE author " +
            "SET lastname = :lastname, " +
            "firstname = :firstname " +
            "WHERE id = :id; ")
    int update(@BindBean Author author);

    @Transaction
    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO author (lastname, firstname) " +
            "VALUES (:lastname, :firstname);")
    int insert(@BindBean Author author);
}
