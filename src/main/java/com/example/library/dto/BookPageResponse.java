package com.example.library.dto;

import java.util.List;

public record BookPageResponse(List<BookResponse> content, int page, int size,
                               long totalElements, int totalPages) {
}
