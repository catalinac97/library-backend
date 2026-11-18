package com.example.library.service;

import com.example.library.dto.BookPageResponse;
import com.example.library.dto.BookResponse;
import com.example.library.entity.Book;
import com.example.library.exception.BookNotFoundException;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookPageResponse findAll(int page, int size) {
        Page<BookResponse> books = bookRepository
                .findAllByActiveTrue(PageRequest.of(page, size, Sort.by("id")))
                .map(BookService::toResponse);
        return new BookPageResponse(books.getContent(), books.getNumber(), books.getSize(),
                books.getTotalElements(), books.getTotalPages());
    }

    public BookResponse findById(long id) {
        return bookRepository.findByIdAndActiveTrue(id)
                .map(BookService::toResponse)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    private static BookResponse toResponse(Book book) {
        return new BookResponse(book.getId(), book.getTitle(), book.getIsbn(), book.isActive(),
                book.getAuthor().getId(), book.getAuthor().getName());
    }
}
