package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Lib extends HashMap<Book, Integer> {
    private static final HashMap<Human, ArrayList<Book>> bookings = new HashMap<>();

    //    public void add(Book item, Student student) {
//        super.add(item);
//        if (actualData.get(item) > 0) {
//            bookings.computeIfAbsent(student, k -> new ArrayList<>());
//            bookings.get(student).add(item);
//        }
//    }

    public List<Book> get(String title) {
        return this.keySet().stream().filter((x) -> Objects.equals((x).getTitle(), title)).collect(Collectors.toList());
    }

    public Optional<Book> get(Integer isbn, Integer copyNumber, String name, Human person) {
        var book = this.keySet().stream().filter(x -> (Objects.equals((x).getTitle(), name))
                && Objects.equals(x.getISBN(), isbn)
                && Objects.equals(x.getCopyNum(), copyNumber)).findFirst();
        book.ifPresent(value -> {
            bookings.get(person).add(value);
            this.put(value, this.get(value) - 1);
        });
        return book;
    }

    public void put(Book order, Human person) {
        this.put(order, this.get(order) + 1);
        bookings.get(person).removeIf(x -> x.equals(order));
    }

    public List<Book> infoByPerson(Human person) {
        return bookings.get(person).stream().toList();
    }

    public HashMap<Book, Integer> libData() {
        return this;
    }
}