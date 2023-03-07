package main;

import main.item.Item;
import main.item.book.Book;
import main.item.other.Other;
import main.pair.Pair;

import java.util.Map;

import main.bookstore.BookStore;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            Book book1 = new Book.BookBuilder("1234567890")
                .setAuthor("John Doe")
                .setName("Book1")
                .setDescription("This is my book")
                .setPrice(9.99)
                .build();
            Book book2 = new Book.BookBuilder("1234567892")
                .setAuthor("John Doe")
                .setName("Book2")
                .setDescription("This is my book")
                .setPrice(9.99)
                .build();
            Other other1 = new Other.OtherBuilder("1234567890123", 0.99)
                .setName("Pen1")
                .setWeight(1.0)
                .build();
            Other other2 = new Other.OtherBuilder("1234567890124", 0.99)
                .setName("Pen2")
                .setWeight(1.0)
                .build();
            
            Pair pairBook1 = new Pair(book1, 5);
            Pair pairBook2 = new Pair(book2, 5);

            Pair pairOther1= new Pair(other2, 10);
            Pair pairOther2 = new Pair(other2, 10);

            BookStore bookStore = new BookStore("BookStore1");
            bookStore.addBook(pairBook1);
            bookStore.addBook(pairBook2);
            bookStore.addOther(pairOther1);
            bookStore.addOther(pairOther2);

            // Print getBookStorePrice
            System.out.println(bookStore.getBookStorePrice());

            // Print getCheapestItem
            System.out.println(bookStore.getCheapestItem());

            // Print getBooksByAuthor
            Map map = bookStore.getBooksByAuthor();
            for(Object key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
