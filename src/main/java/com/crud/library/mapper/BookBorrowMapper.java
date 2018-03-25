package com.crud.library.mapper;

import com.crud.library.domain.BookBorrow;
import com.crud.library.domain.BookBorrowDto;
import org.springframework.stereotype.Component;

@Component
public class BookBorrowMapper {

    public BookBorrow mapToBookBorrow(final BookBorrowDto bookBorrowDtoDto){
        return new BookBorrow(
                bookBorrowDtoDto.getId(),
                bookBorrowDtoDto.getBookCopy(),
                bookBorrowDtoDto.getReader(),
                bookBorrowDtoDto.getCreatedDate(),
                bookBorrowDtoDto.getReturndDate());
    }

    public BookBorrowDto mapToBookBorrowDto (final BookBorrow bookBorrow){
        return new BookBorrowDto(
                bookBorrow.getId(),
                bookBorrow.getBookCopy(),
                bookBorrow.getReader(),
                bookBorrow.getCreatedDate(),
                bookBorrow.getReturndDate());
    }
}
