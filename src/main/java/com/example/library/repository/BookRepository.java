package com.example.library.repository;

import com.example.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface BookRepository extends Repository<Book, Long> {
    @EntityGraph(attributePaths = "author")
    Page<Book> findAllByActiveTrue(Pageable pageable);

    @EntityGraph(attributePaths = "author")
    Optional<Book> findByIdAndActiveTrue(long id);
}
