package com.crud.library.controller;

import com.crud.library.domain.*;
import com.crud.library.mapper.BookBorrowMapper;
import com.crud.library.mapper.BookCopyMapper;
import com.crud.library.mapper.BookTitleMapper;
import com.crud.library.mapper.ReaderMapper;
import com.crud.library.service.DbService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import static com.crud.library.domain.BookCopyStatus.BORROWED;
import static com.crud.library.domain.BookCopyStatus.FREE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/")
public class LibraryController {

    @Autowired
    private DbService service;

    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private BookTitleMapper bookTitleMapper;

    @Autowired
    private BookCopyMapper bookCopyMapper;

    @Autowired
    private BookBorrowMapper bookBorrowMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/readers")
    public List<ReaderDto> getReaders(){
        return readerMapper.
                mapToReaderDtoList(service.getAllReaders());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/readers", consumes = APPLICATION_JSON_VALUE)
    public ReaderDto createReader (@RequestBody ReaderDto readerDto){
        return readerMapper
                .mapToReaderDto(service
                        .save(readerMapper.mapToReader(readerDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/titles", consumes = APPLICATION_JSON_VALUE)
    public BookTitleDto createBookTitle (@RequestBody BookTitleDto bookTitleDto){
        return bookTitleMapper
                .mapToBookTitleDto(service
                        .save(bookTitleMapper.mapToBookTitle(bookTitleDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bookCopy", consumes = APPLICATION_JSON_VALUE)
    public BookCopyDto createBookCopy (@RequestBody BookCopyDto bookCopyDto){
        return bookCopyMapper
                .mapToBookCopyDto(service
                        .save(bookCopyMapper.mapToBookCopy(bookCopyDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateBookCopy")
    public void updateBookCopy(@RequestBody BookCopyDto bookCopyDto){
           bookCopyMapper
                   .mapToBookCopyDto(service
                           .save(bookCopyMapper.mapToBookCopy(bookCopyDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getFreeBookCopies/{bookId}")
    public BigInteger getFreeBooksCopies(@PathVariable Long bookId) throws TaskNotFoundException {
        return service.getAllAvialableBookCopies(bookId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bookBorrow", consumes = APPLICATION_JSON_VALUE)
    public BookBorrowDto createBookBorrow (@RequestBody BookBorrowDto bookBorrowDto){

        BookCopy bookCopy = bookBorrowDto.getBookCopy();
        BigInteger excpeted = BigInteger.valueOf(0);

        boolean avialableBook = (service.getAllAvialableBookCopies(bookCopy.getBookTitle().getId()) != excpeted)?true:false;

        if (avialableBook) {
            bookCopy.setStatus("borrowed");
            service.save(bookCopy);
            return bookBorrowMapper
                    .mapToBookBorrowDto(service
                            .save(bookBorrowMapper.mapToBookBorrow(bookBorrowDto)));
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/returnBookCopy")
    public void updateReturnBookCopy(@RequestBody BookBorrowDto bookBorrowDto) {

        bookBorrowMapper
                .mapToBookBorrowDto(service
                        .save(bookBorrowMapper.mapToBookBorrow(bookBorrowDto)));

        BookCopy bookCopy = bookBorrowDto.getBookCopy();
        bookCopy.setStatus("free");
        service.save(bookCopy);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/booksBorrowed")
    public List<BooksBorrowedDto> getBooksBorrowedByReaders(){
        return service.booksBorrowedByReaders();
    }

}
