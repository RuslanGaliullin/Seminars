package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Library extends HashMap<Book, Integer> {
    private final HashMap<Human, ArrayList<Book>> bookings = new HashMap<>();


    public void put(Book key) {
        if (this.containsKey(key)) {
            super.put(key, super.get(key) + 1);
            return;
        }
        super.put(key, 1);
    }


    public List<Book> get(String title) {
        return this.keySet().stream().filter((x) -> Objects.equals((x).getTitle(), title) && this.get(x) > 0).collect(Collectors.toList());
    }

    public void orderBook(Integer isbn, String name, Human person) {
        var book = this.keySet().stream().filter(x -> (Objects.equals((x).getTitle(), name))
                && Objects.equals(x.getISBN(), isbn) && this.get(x) > 0).findFirst();
        book.ifPresent(value -> {
            if (!bookings.containsKey(person)) {
                bookings.put(person, new ArrayList<>());
            }
            bookings.get(person).add(value);
            this.put(value, this.get(value) - 1);
        });
    }

    public void returnBook(String bookName, Human person) {
        var book = this.keySet().stream().filter(x -> Objects.equals(x.getTitle(), bookName)).findFirst();
        book.ifPresent(value -> {
            this.put(value);
            bookings.get(person).removeIf(x -> x.equals(value));
        });
    }

    public List<Book> infoByPerson(Human person) {
        if (bookings.isEmpty()) {
            return new ArrayList<>();
        }
        return bookings.get(person).stream().toList();
    }
}