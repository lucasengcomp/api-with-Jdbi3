package com.crudapiwithJdbi3.domain.book.entitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;

    @NotEmpty
    @Size(max = 100)
    private String title;

    private Integer page;

    private String isbn;

    private String description;

    private BigDecimal price;
}
