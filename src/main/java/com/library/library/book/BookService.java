package com.library.library.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class BookService {

    final private DateTimeFormatter dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

    private List<BookEntity> books = Arrays.asList(
            new BookEntity(1L, "Ogniem i mieczem", "Henryk Sienkiewicz", LocalDate.of(1884, 12, 23)),
            new BookEntity(2L, "Potop", "Henryk Sienkiewicz", LocalDate.of(1886, 3, 17)),
            new BookEntity(3L, "Harry Potter", "J.K. Rowling", LocalDate.of(1997, 6, 26))
    );

    List<Book> getBooks() {
        return books.stream()
                .map(this::mapBookEntityToBook)
                .collect(Collectors.toList());
    }

    private Book mapBookEntityToBook(final BookEntity bookEntity) {
        return Book.builder()
                .id(bookEntity.getId())
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .releaseDate(dateFormat.format(bookEntity.getReleaseDate()))
                .build();
    }

}
