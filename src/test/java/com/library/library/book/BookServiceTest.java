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
                        new Book(1L, "Ogniem i mieczem", "Henryk Sienkiewicz", "December 23, 1884"),
                        new Book(2L, "Potop", "Henryk Sienkiewicz", "March 17, 1886"),
                        new Book(3L, "Harry Potter", "J.K. Rowling", "June 26, 1997")
                ));
    }
}