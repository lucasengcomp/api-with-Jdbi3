package com.crudapiwithJdbi3.domain.book.respository;

import com.crudapiwithJdbi3.domain.book.entitie.Book;
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
@RegisterBeanMapper(Book.class)
public interface BookRepository {

    @SqlQuery("SELECT * FROM book")
    List<Book> findAll();

    @SqlQuery("SELECT * FROM book WHERE id = :id")
    Book findById(@Bind("id") long id);

    @Transaction
    @SqlUpdate("delete FROM book WHERE id = :id")
    int deleteById(@Bind("id") long id);

    @Transaction
    @SqlUpdate("UPDATE book " +
            "SET title = :title, " +
            "page = :page, " +
            "isbn = :isbn, " +
            "description = :description," +
            "price = :price " +
            "WHERE id = :id")
    int update(@BindBean Book book);

    @Transaction
    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO book (title, page, isbn, description, price) " +
            "VALUES (:title, :page, :isbn, :description, :price)")
    int insert(@BindBean Book book);
}
