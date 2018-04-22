package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BooksAvialableToBorrow {

    @Id
    private Long id;

    private String author;

    private String title;

    private Long publication_date;

    private Long copy_id;

    private Long free_books;
}
