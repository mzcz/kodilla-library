package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookBorrowDto {

    private Long id;
    private BookCopy bookCopy;
    private Reader reader;
    private LocalDate createdDate;
    private LocalDate returndDate;
}
