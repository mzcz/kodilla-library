package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookBorrowDto {

    private Long id;
    private BookCopy bookCopy;
    private Reader reader;
    private LocalDate createdDate;
    private LocalDate returndDate;
}
