package com.crud.library.repository;

import com.crud.library.domain.BookBorrow;
import com.crud.library.domain.BookCopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookBorrowRepository extends CrudRepository<BookBorrow, Long> {

        @Override
        Optional<BookBorrow> findById(Long id);

        @Override
        BookBorrow save(BookBorrow bookBorrow);

        @Override
        void delete(BookBorrow bookBorrow);

}
