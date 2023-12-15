package com.library.library.book;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(exclude = {"id"})
class BookEntity {
    private UUID id;
    private String title;
    private String author;
    private LocalDate releaseDate;
}
