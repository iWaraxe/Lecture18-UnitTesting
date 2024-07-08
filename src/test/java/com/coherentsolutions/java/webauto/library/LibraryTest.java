package com.coherentsolutions.java.webauto.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LibraryTest {

    private Library library;
    private Book testBook;

    @BeforeEach
    public void setUp() {
        library = new Library();
        testBook = new Book("Test Title", "Test Author", 2020);
        library.addBook(testBook);
    }

    @Test
    public void testGetBookByTitle() {
        Book actualBook = library.getBookByTitle("Test Title");
        assertEquals(testBook, actualBook);
    }

    @Test
    public void testGetBooksByAuthor() {
        List<Book> actualBooks = library.getBooksByAuthor("Test Author");
        assertEquals(List.of(testBook), actualBooks);
    }

    @Test
    public void testGetBooksByYear() {
        List<Book> actualBooks = library.getBooksByYear(2020);
        assertEquals(List.of(testBook), actualBooks);
    }

    @Test
    public void testIsBookExistedByTitle() {
        assertTrue(library.isBookExistedByTitle("Test Title"));
    }

    @Test
    public void testIsBookExistedByAuthor() {
        assertTrue(library.isBookExistedByAuthor("Test Author"));
    }

    @Test
    public void testGetBooksByYear_StringFormat() throws InvalidYearException {
        List<Book> actualBooks = library.getBooksByYear("2020");
        assertEquals(List.of(testBook), actualBooks);
    }

    @Test
    public void testGetBooksByYear_InvalidYearException() {
        assertThrows(InvalidYearException.class, () -> {
            library.getBooksByYear("invalid_year");
        });
    }
}