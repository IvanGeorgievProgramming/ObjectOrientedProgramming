package main;

import main.item.Item;
import main.item.book.Book;
import main.item.other.Other;
import main.pair.Pair;

public class App {
    public static void main(String[] args) throws Exception {
        // Make a new book using BookBuilder
        Book book = new Book.BookBuilder("1234567890")
            .setAuthor("John Doe")
            .setName("Book")
            .setDescription("This is my book")
            .setPrice(9.99)
            .build();
        // Make a new other using OtherBuilder
        Other other = new Other.OtherBuilder("1234567890123", 0.99)
            .setName("Pen")
            .setWeight(1.0)
            .build();

        // Make a new pairBook
        Pair pairBook = new Pair(book, 5);
        // Make a new pairOther
        Pair pairOther = new Pair(other, 10);

        // Print the pairBook
        pairBook.print();
        // Print the pairOther
        pairOther.print();
    }
}
