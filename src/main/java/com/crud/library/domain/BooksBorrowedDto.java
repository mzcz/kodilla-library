package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BooksBorrowedDto {

    @Id
    private Long id;

    private String title;

    private String name;

    private Long reader;

    private Long book_copy;

    private Long book;

    private LocalDate created_date;

    private LocalDate return_date;

}
