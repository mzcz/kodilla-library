package com.crud.library.repository;

import com.crud.library.domain.BookBorrowDto;
import com.crud.library.domain.BookCopyDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager em;

    public BigInteger getAllAvialableBookCopies(Long bookId){

        String SearchQuery = "SELECT count(*)  FROM library_crud.bookcopies bc\n" +
                "join library_crud.books b\n" +
                "on b.id = bc.book_id\n" +
                "where bc.status='free' and b.id = " + bookId;

        return (BigInteger) em.createNativeQuery(SearchQuery).getSingleResult();

    };

    public BookBorrowDto returnBorrowedBook(Long bookCopyId){
        String SearchQuery = "select * FROM library_crud.bookborrows  where book_copy_id = " +
                + bookCopyId + " and return_date is null";

        return (BookBorrowDto) em.createNativeQuery(SearchQuery, BookBorrowDto.class);
    }
}
