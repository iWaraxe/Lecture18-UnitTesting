package com.coherentsolutions.java.webauto;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.List;

public class LibraryTestNG {

    private Library library;
    private Book testBook;

    @BeforeMethod
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

    @Test(expectedExceptions = InvalidYearException.class)
    public void testGetBooksByYear_InvalidYearException() throws InvalidYearException {
        library.getBooksByYear("invalid_year");
    }
}