package main;

import main.item.book.Book;
import main.item.other.Other;

public class App {
    public static void main(String[] args) throws Exception {
        // Make a new book using BookBuilder
        Book book = new Book.BookBuilder("1234567890")
            .setAuthor("John Doe")
            .setName("My Book")
            .setDescription("This is my book")
            .setPrice(9.99)
            .build();

        // Print the book
        book.print();

        // Make a new other using OtherBuilder
        Other other = new Other.OtherBuilder("1234567890123", 9.99)
            .setName("My Other")
            .setWeight(1.0)
            .build();
        
        // Print the other
        other.print();
    }
}
