package com.crud.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="BOOKS")
public class BookTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLICATION_DATE")
    private int publicationDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookTitle")
    private Set<BookCopy> bookCopies;

    public BookTitle(){};

    public BookTitle(String title, String author, int publicationDate, Set<BookCopy> bookCopies) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.bookCopies = bookCopies;
    }

    public BookTitle(Long id, String title, String author, int publicationDate, Set<BookCopy> bookCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.bookCopies = bookCopies;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public Set<BookCopy> getBookCopies() {
        return bookCopies;
    }
}
