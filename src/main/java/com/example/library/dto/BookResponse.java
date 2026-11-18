package com.example.library.dto;

public record BookResponse(Long id, String title, String isbn, boolean active,
                           Long authorId, String authorName) {
}
