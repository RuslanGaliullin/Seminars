package org.example;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Book {
    private final String Title;

    private final Date pubDate;


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

    public Date getPubDate() {
        return pubDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Title.equals(book.Title)
                && ISBN.equals(book.ISBN)
                && authors.equals(book.authors)
                && pubDate.equals(book.pubDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Title, ISBN, authors, pubDate);
    }

    public Book(String title, Date pubDate, Integer isbn, List<String> authors) {
        Title = title;
        this.pubDate = pubDate;
        ISBN = isbn;
        this.authors = authors;
    }
}
