package org.example;

import org.w3c.dom.ranges.RangeException;

import java.util.*;

public class Main {
    static void generateBooksInTheLib(Library lib) {
        lib.put(new Book(
                "Algorithm and Data structure",
                new Date(2009, Calendar.AUGUST, 31), 1,
                new ArrayList<>() {{
                    add("Thomas H. Cormen");
                    add("Charles E. Leiserson");
                }}));
        lib.put(new Book(
                "Algorithm and Data structure",
                new Date(2009, Calendar.AUGUST, 31), 1,
                new ArrayList<>() {{
                    add("Thomas H. Cormen");
                    add("Charles E. Leiserson");
                }}));
        lib.put(new Book(
                "Algorithm and Data structure",
                new Date(2009, Calendar.AUGUST, 31), 1,
                new ArrayList<>() {{
                    add("Thomas H. Cormen");
                    add("Charles E. Leiserson");
                }}));
        lib.put(new Book(
                "Algorithm and Data structure",
                new Date(2015, Calendar.AUGUST, 31), 3,
                new ArrayList<>() {{
                    add("Ruslan");
                }}));
        lib.put(new Book(
                "Sherlock Holmes",
                new Date(1887, Calendar.AUGUST, 31), 4,
                new ArrayList<>() {{
                    add("Sir Arthur Ignatius Conan Doyle");
                }}));
        lib.put(new Book(
                "Sherlock Holmes",
                new Date(1887, Calendar.AUGUST, 31), 4,
                new ArrayList<>() {{
                    add("Sir Arthur Ignatius Conan Doyle");
                }}));
    }

    static Optional<Book> getBook(Library lib, String title) {
        var result = lib.get(title);
        for (int i = 0; i < result.size(); ++i) {
            System.out.println("Book " + (i + 1) + ": " + result.get(i).getTitle() + " ISBN: " + result.get(i).getISBN());
        }
        if (result.size() == 0) {
            System.out.println("You can't order this book");
            return Optional.empty();
        }
        Scanner scanner;
        do {
            scanner = new Scanner(System.in);
            String commandLine = scanner.nextLine();
            try {
                return Optional.of(result.get(Integer.parseInt(commandLine) - 1));
            } catch (NumberFormatException e) {
                System.out.println("Enter the number");
            } catch (Exception e) {
                System.out.println("The book with this number is not presented");
            }
        } while (true);
    }

    public static void main(String[] args) {
        Library pokraLibrary = new Library();
        generateBooksInTheLib(pokraLibrary);
        Scanner scanner;
        Human student = new Human(1234, "Max", "Mad");
        do {
            scanner = new Scanner(System.in);
            String[] commandLine = scanner.nextLine().split(" ", 2);
            if (commandLine.length > 2 || commandLine.length < 1) {
                System.out.println("Wrong command");
            } else if (commandLine.length == 2 && Objects.equals(commandLine[0], "get")) {
                var wantedBook = getBook(pokraLibrary, commandLine[1]);
                wantedBook.ifPresent(value -> pokraLibrary.orderBook(wantedBook.get().getISBN(), wantedBook.get().getTitle(), student));
            } else if (commandLine.length == 2 && Objects.equals(commandLine[0], "put")) {
                pokraLibrary.returnBook(commandLine[1], student);
            } else if (commandLine.length == 1 && Objects.equals(commandLine[0], "list")) {
                System.out.println(student.surname() + student.name() + " ordered");
                for (var i : pokraLibrary.infoByPerson(student)) {
                    System.out.println(i.getTitle() + " ISBN: " + i.getISBN());
                }
            } else if (commandLine.length == 1 && Objects.equals(commandLine[0], "all")) {
                System.out.println("Now in library:");
                for (var i : pokraLibrary.keySet()) {
                    System.out.println(i.getTitle() + " ISBN: " + i.getISBN() + " in quantity of " + pokraLibrary.get(i));
                }
                System.out.println("And people took:");
                for (var i : pokraLibrary.infoByPerson(student)) {
                    System.out.println(i.getTitle() + " ISBN: " + i.getISBN());
                }
            }
            System.out.println();
        } while (true);

    }

}