package com.crudapiwithJdbi3.domain.book.entitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;

    private String title;

    private Integer page;

    private String isbn;

    private String description;

    private BigDecimal price;
}
