package com.crud.library.mapper;

import com.crud.library.domain.BookCopy;
import com.crud.library.domain.BookCopyDto;
import org.springframework.stereotype.Component;


@Component
public class BookCopyMapper {

    public BookCopy mapToBookCopy(final BookCopyDto bookCopyDto){
        return new BookCopy(
                bookCopyDto.getId(),
                bookCopyDto.getBookTitle(),
                bookCopyDto.getStatus(),
                null);
    }

    public BookCopyDto mapToBookCopyDto (final BookCopy bookCopy){
        return new BookCopyDto(
                bookCopy.getId(),
                bookCopy.getBookTitle(),
                bookCopy.getStatus(),
        null);
    }

}
