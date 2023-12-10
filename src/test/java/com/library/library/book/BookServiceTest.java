package com.library.library.book;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BookServiceTest {

    private BookService bookService = new BookService();

    @Test
    void getBooks() {
        // when
        final var books = bookService.getBooks();

        // then
        assertThat(books)
                .isNotEmpty()
                .containsExactlyInAnyOrderElementsOf(Arrays.asList(
                        new Book(1L, "Ogniem i mieczem", "Henryk Sienkiewicz", "23 grudnia 1884"),
                        new Book(2L, "Potop", "Henryk Sienkiewicz", "17 marca 1886"),
                        new Book(3L, "Harry Potter", "J.K. Rowling", "26 czerwca 1997")
                ));
    }
}