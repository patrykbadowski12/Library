package com.library.library.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode(exclude = {"id"})
class Book {
    private UUID id;
    private String title;
    private String author;
    private String releaseDate;
}
