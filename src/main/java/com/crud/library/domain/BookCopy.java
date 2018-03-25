package com.crud.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="BOOKCOPIES")
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID")
    private BookTitle bookTitle;

    @Column(name = "STATUS")
    private String status;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "bookCopy")
    private BookBorrow bookBorrow;

    public BookCopy(){};

    public BookCopy(BookTitle bookTitle, String status) {
        this.bookTitle = bookTitle;
        this.status = status;
    }

    public BookCopy(Long id, BookTitle bookTitle, String status, BookBorrow bookBorrow) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.status = status;
        this.bookBorrow = bookBorrow;
    }

    public Long getId() {
        return id;
    }

    public BookTitle getBookTitle() {
        return bookTitle;
    }

    public String getStatus() {
        return status;
    }

    public BookBorrow getBookBorrow() {
        return bookBorrow;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
