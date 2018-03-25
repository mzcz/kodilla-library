package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCopyDto {

    private Long id;
    private BookTitle bookTitle;
    private String status;
    private Set<BookBorrow> bookBorrow;
}
