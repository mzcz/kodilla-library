package com.crud.library.service;

import com.crud.library.controller.TaskNotFoundException;
import com.crud.library.domain.*;
import com.crud.library.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class DbService {

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookTitleRepository bookTitleRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookBorrowRepository bookBorrowRepository;

    //Reader
    public Reader save(final Reader reader){
        return readerRepository.save(reader);
    }

    public List<Reader> getAllReaders(){
        return readerRepository.findAll();
    }

    public Reader getReader(final Long id){
        return readerRepository.findById(id).orElse(null);
    }

    public void delete(final Reader reader){
        readerRepository.delete(reader);
    }

    //BookTtile
    public BookTitle save(final BookTitle bookTitle){
        return bookTitleRepository.save(bookTitle);
    }

    public List<BookTitle> getAllBooksTitle(){
        return bookTitleRepository.findAll();
    }

    public BookTitle getBookTitle(final Long id){
        return bookTitleRepository.findById(id).orElse(null);
    }


    public void delete(final BookTitle bookTitle){
        bookTitleRepository.delete(bookTitle);
    }

    //BookCopy
    public BookCopy save(final BookCopy bookCopy){
        return bookCopyRepository.save(bookCopy);
    }

    public List<BookCopy> getAllBookCopies(){
        return bookCopyRepository.findAll();
    }

    public List<BooksAvialableToBorrow> getAvialableBookCopies(){
        return bookDao.getAvialableBookCopies();
    }

    public BookCopy getBookCopy(final Long id) {
        return bookCopyRepository.findById(id).orElse(null);
    }

    public void delete(final BookCopy bookCopy){
        bookCopyRepository.delete(bookCopy);
    }

    //change status
    public BigInteger getAllAvialableBookCopies(final Long bookId){
        return bookDao.getAvialableBookCopies(bookId);
    }

    //BookBorrow

    public BookBorrow getBookBorrow(final Long id){
        return bookBorrowRepository.findById(id).orElse(null);
    }
    public BookBorrow save(final BookBorrow bookBorrow){
        return bookBorrowRepository.save(bookBorrow);
    }

    public void delete(final BookBorrow bookBorrow){
        bookBorrowRepository.delete(bookBorrow);
    }

    //return Book

    public BookBorrowDto updateReturnBookCopy(final Long bookId){
        return bookDao.returnBorrowedBook(bookId);
    }

    public List<BooksBorrowedDto> booksBorrowedByReaders(){
        return bookDao.booksBorrowedByReaders();
    }

}
