package com.crud.library;

import com.crud.library.domain.*;
import com.crud.library.repository.BookDao;
import com.crud.library.service.DbService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryDaoTestSuite {

    @Autowired
    private DbService repository;

    @Test
    public void ReaderTestDaoSave() {

        //Given
        Reader reader = new Reader("test","Testowy", LocalDate.now());

        //When

        repository.save(reader);
        Long id = reader.getId();
        System.out.println(id);

        //Then

        Reader readTask = repository.getReader(id);

        Assert.assertEquals(id, readTask.getId());

        //CleanUp
        repository.delete(readTask);
    }

    @Ignore
    @Test
    public void BookTitleTestDaoSave() {

        //Given
        BookTitle book = new BookTitle(1L,"ksiazkaTestowa","AutorTestowy", 2008,null);

        //When

        repository.save(book);
        Long bookId = book.getId();
        System.out.println(bookId);

        //Then

        BookTitle bookTitle = repository.getBookTitle(bookId);

        Assert.assertEquals(bookId, bookTitle.getId());

        //CleanUp
        repository.delete(bookTitle);
    }


    @Test
    public void BookCopyDaoTest() {

        //Given
        Reader reader = new Reader("test1","Testowy1", LocalDate.now());
        BookTitle book = new BookTitle("ksiazkaTestowa1","AutorTestowy1", 2018, null);
        BookCopy  copy = new BookCopy(book,"free");
        BookBorrow borrow = new BookBorrow(copy,reader, LocalDate.now(),null);



        repository.save(reader);
        Long id = reader.getId();
        System.out.println("Reader id " +id);

        repository.save(book);
        Long bookId = book.getId();
        System.out.println("Book id " + bookId);

        repository.save(copy);
        Long bookCopyId = copy.getId();
        System.out.println("Book copy id " + bookCopyId);

        repository.save(borrow);
        Long bookBorowId = borrow.getId();
        System.out.println("Book borrow id " + bookBorowId);


        Reader readerBook = repository.getReader(id);
        BookTitle bookTitle = repository.getBookTitle(bookId);
        BookCopy bookCopy = repository.getBookCopy(bookCopyId);
        BookBorrow bookBorrow = repository.getBookBorrow(bookBorowId);

        Integer myInteger = 1;
        BigInteger excpeted = BigInteger.valueOf(myInteger.intValue());

        //When
        BigInteger allBooks = repository.getAllAvialableBookCopies(book.getId());
        System.out.println("all books " + allBooks);

        //Then
        Assert.assertEquals(excpeted, allBooks);
        Assert.assertEquals(id, readerBook.getId());
        Assert.assertEquals(bookId, bookTitle.getId());
        Assert.assertEquals(bookCopyId, bookCopy.getId());
        Assert.assertEquals(bookBorowId, bookBorrow.getId());

        //CleanUp
        repository.delete(readerBook);
        repository.delete(bookTitle);
        repository.delete(bookCopy);
        repository.delete(bookBorrow);
    }

    @Test
    public void BookBorrowedByUsersTest() {

        //Given

        //When

        List<BooksBorrowedDto> listBorrowedBooks = repository.booksBorrowedByReaders();
        for (BooksBorrowedDto list: listBorrowedBooks){
            System.out.println(list.getId() + " " + list.getTitle() + " " + list.getName());
        }

        //Then


        //Assert.assertEquals(bookId, bookTitle.getId());


    }

}
