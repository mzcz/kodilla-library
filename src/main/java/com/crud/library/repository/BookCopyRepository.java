package com.crud.library.repository;

import com.crud.library.domain.BookCopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {

    @Override
    List<BookCopy> findAll();

    @Override
    Optional<BookCopy> findById(Long id);

    @Override
    BookCopy save(BookCopy bookCopy);

    @Override
    void delete(BookCopy bookCopy);

}
