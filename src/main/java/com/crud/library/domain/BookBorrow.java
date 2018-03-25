package com.crud.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="BOOKBORROWS")
public class BookBorrow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_COPY_ID")
    private BookCopy bookCopy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    @NotNull
    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returndDate;

    public BookBorrow(){};

    public BookBorrow(BookCopy bookCopy, Reader reader, LocalDate createdDate, LocalDate returndDate) {
        this.bookCopy = bookCopy;
        this.reader = reader;
        this.createdDate = createdDate;
        this.returndDate = returndDate;
    }

    public BookBorrow(Long id, BookCopy bookCopy, Reader reader, LocalDate createdDate, LocalDate returndDate) {
        this.id = id;
        this.bookCopy = bookCopy;
        this.reader = reader;
        this.createdDate = createdDate;
        this.returndDate = returndDate;
    }

    public Long getId() {
        return id;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public Reader getReader() {
        return reader;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getReturndDate() {
        return returndDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setReturndDate(LocalDate returndDate) {
        this.returndDate = returndDate;
    }
}
