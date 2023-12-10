package com.library.library.book;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
class BookEntity {
    private Long id;
    private String title;
    private String author;
    private LocalDate releaseDate;
}
