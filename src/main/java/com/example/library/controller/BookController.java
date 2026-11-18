package com.example.library.controller;

import com.example.library.dto.BookPageResponse;
import com.example.library.dto.BookResponse;
import com.example.library.service.BookService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public BookPageResponse findAll(
            @RequestParam(defaultValue = "0") @Min(value = 0, message = "page must be at least 0") int page,
            @RequestParam(defaultValue = "20")
            @Min(value = 1, message = "size must be at least 1")
            @Max(value = 100, message = "size must be at most 100") int size) {
        return bookService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable @Positive(message = "id must be positive") long id) {
        return bookService.findById(id);
    }
}
