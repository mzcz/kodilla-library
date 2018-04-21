package com.crud.library.repository;

import com.crud.library.domain.BookBorrowDto;
import com.crud.library.domain.BookCopyDto;
import com.crud.library.domain.BooksAvialableToBorrow;
import com.crud.library.domain.BooksBorrowedDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;

@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager em;

    public BigInteger getAvialableBookCopies(Long bookId){

        String SearchQuery = "SELECT count(*)  FROM bookcopies bc\n" +
                "join books b\n" +
                "on b.id = bc.book_id\n" +
                "where bc.status='free' and b.id = " + bookId;

        return (BigInteger) em.createNativeQuery(SearchQuery).getSingleResult();

    };

    @SuppressWarnings("unchecked")
    public List<BooksAvialableToBorrow> getAvialableBookCopies(){

        String SearchQuery = "select id, author, title, publication_date, copy_id from (                \n" +
                "select b.*, \n" +
                "(select min(bc.id) from bookcopies bc where bc.book_id = b.id\n" +
                "and bc.status='free'\n" +
                ") copy_id  from books b) t where t.copy_id is not null;   ";

        return em.createNativeQuery(SearchQuery,BooksAvialableToBorrow.class).getResultList();

    };

    public BookBorrowDto returnBorrowedBook(Long bookCopyId){
        String SearchQuery = "select * FROM bookborrows  where book_copy_id = " +
                + bookCopyId + " and return_date is null";

        return (BookBorrowDto) em.createNativeQuery(SearchQuery, BookBorrowDto.class);
    }


    @SuppressWarnings("unchecked")
    public List<BooksBorrowedDto> booksBorrowedByReaders(){

        String SearchQuery = "select  bb.id, b.title, concat (r.first_name,\" \", r.last_name) as name, \n" +
                " bb.reader_id as reader, bb.book_copy_id as book_copy, bc.book_id as book, \n" +
                " bb.created_date, bb.return_date \n" +
                " from bookborrows bb\n" +
                "join bookcopies bc on bc.id = bb.book_copy_id\n" +
                "join books b on b.id = bc.book_id\n" +
                "join readers r on r.id = bb.reader_id \n" +
                "where bb.return_date is null \n" +
                "and bc.status='borrowed'" +
                "order by bb.id asc ";

        return em.createNativeQuery(SearchQuery,BooksBorrowedDto.class).getResultList();

    };

}
