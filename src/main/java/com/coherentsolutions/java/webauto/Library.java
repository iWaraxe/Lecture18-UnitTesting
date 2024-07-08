package com.coherentsolutions.java.webauto;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private Map<Integer, Book> books = new HashMap<>();
    private int idCounter = 0;

    public void addBook(Book book) {
        books.put(idCounter++, book);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    public List<Book> getBooksByAuthor(String author) {
        return books.values().stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByYear(int year) {
        return books.values().stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    public boolean isBookExistedByTitle(String title) {
        return books.values().stream()
                .anyMatch(book -> book.getTitle().equals(title));
    }

    public boolean isBookExistedByAuthor(String author) {
        return books.values().stream()
                .anyMatch(book -> book.getAuthor().equals(author));
    }

    public List<Book> getBooksByYear(String year) throws InvalidYearException {
        try {
            int yr = Integer.parseInt(year);
            return books.values().stream()
                    .filter(book -> book.getPublicationYear() == yr)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InvalidYearException("Invalid year format: " + year);
        }
    }
}