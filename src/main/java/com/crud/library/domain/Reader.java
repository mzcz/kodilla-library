package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="READERS")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reader")
    private Set<BookBorrow> bookBorrows;

    public Reader(){}


    public Reader(String firstName, String lastName, LocalDate createdDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdDate = createdDate;
    }



    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }
}
