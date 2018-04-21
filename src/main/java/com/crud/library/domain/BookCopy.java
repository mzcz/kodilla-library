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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookCopy")
    private Set<BookBorrow> bookBorrow;

    public BookCopy(){};

    public BookCopy(BookTitle bookTitle, String status) {
        this.bookTitle = bookTitle;
        this.status = status;
    }

    public BookCopy(Long id, BookTitle bookTitle, String status, Set<BookBorrow> bookBorrow) {
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

    public Set<BookBorrow> getBookBorrow() {
        return bookBorrow;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBookTitle(BookTitle bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
