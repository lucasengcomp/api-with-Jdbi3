package com.crudapiwithJdbi3.domain.author.entitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty
    private String lastname;

    @NotEmpty
    private String firstname;
}
