package com.library.library.book;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
class Book {
    private Long id;
    private String title;
    private String author;
    private String releaseDate;
}
