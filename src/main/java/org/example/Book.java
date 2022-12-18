package org.example;

import java.util.List;
import java.util.Objects;

public class Book {
    private final Integer copyNum;
    private final String Title;

    public Integer getCopyNum() {
        return copyNum;
    }

    private final Integer ISBN;
    private final List<String> authors;

    public String getTitle() {
        return Title;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public List<String> getAuthors() {
        return authors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return copyNum.equals(book.copyNum) && Title.equals(book.Title) && ISBN.equals(book.ISBN) && authors.equals(book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(copyNum, Title, ISBN, authors);
    }

    public Book(Integer copyNum, String title, Integer isbn, List<String> authors) {
        this.copyNum = copyNum;
        Title = title;
        ISBN = isbn;
        this.authors = authors;
    }
}
