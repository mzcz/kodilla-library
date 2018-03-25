package com.crud.library.mapper;

import com.crud.library.domain.BookTitle;
import com.crud.library.domain.BookTitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookTitleMapper {

    public BookTitle mapToBookTitle(final BookTitleDto bookTitleDto){
        return new BookTitle(
                bookTitleDto.getId(),
                bookTitleDto.getTitle(),
                bookTitleDto.getAuthor(),
                bookTitleDto.getPublicationDate(),
                null);
    }

    public BookTitleDto mapToBookTitleDto (final BookTitle bookTitle){
        return new BookTitleDto(
                bookTitle.getId(),
                bookTitle.getTitle(),
                bookTitle.getAuthor(),
                bookTitle.getPublicationDate());
    }

    public List<BookTitleDto> mapToBookTitleDtoList (final List<BookTitle> bookTitleList){
        return bookTitleList.stream()
                .map(t -> new BookTitleDto(t.getId(), t.getTitle(), t.getAuthor(), t.getPublicationDate()))
                .collect(Collectors.toList());
    }
}
