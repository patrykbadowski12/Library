package com.library.library.book;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.UUID;

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
                        new Book(UUID.randomUUID(), "Ogniem i mieczem", "Henryk Sienkiewicz", "December 23, 1884"),
                        new Book(UUID.randomUUID(), "Potop", "Henryk Sienkiewicz", "March 17, 1886"),
                        new Book(UUID.randomUUID(), "Harry Potter", "J.K. Rowling", "June 26, 1997")
                ));
    }

    @Test
    void findBookById() {
        // given
        final var id = bookService.getBooks().get(2).getId();

        // when
        final var book = bookService.getBookById(id.toString());

        // then
        assertThat(book).isNotEmpty()
                .contains(Book.builder()
                        .title("Harry Potter")
                        .author("J.K. Rowling")
                        .releaseDate("June 26, 1997")
                        .build());
    }

    @Test
    void createBook() {
        // given
        final var book = new Book(null, "Test Book", "Test Title", "January 12, 1952");

        // when
        bookService.createBook(book);

        // then
        assertThat(bookService.getBooks()).hasSize(4);
    }

    @Test
    void removeBookById() {
        // given
        final var book = bookService.getBooks().stream().findFirst().get();

        bookService.removeBookById(book.getId().toString());

        assertThat(bookService.getBooks()).doesNotContain(book);
    }
}