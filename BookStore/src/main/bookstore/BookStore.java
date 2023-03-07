package main.bookstore;

import java.util.*;

import main.pair.Pair;
import main.item.Item;
import main.item.book.Book;
import main.item.other.Other;

public class BookStore {

    // * Parameters

    private String name;
    private List<Pair<Book, Integer>> books;
    private List<Pair<Other, Integer>> others;

    // * Constructors

    public BookStore(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.others = new ArrayList<>();
    }

    // * Getters

    public String getName() {
        return name;
    }

    public List<Pair<Book, Integer>> getBooks() {
        return books;
    }

    public List<Pair<Other, Integer>> getOthers() {
        return others;
    }

    // * Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Pair<Book, Integer>> books) {
        this.books = books;
    }

    public void setOthers(List<Pair<Other, Integer>> others) {
        this.others = others;
    }

    // * Methods

    public void addBook(Pair<Book, Integer> book) {
        for(Pair<Book, Integer> pair : books) {
            if(pair.getItem().getIsbn().equals(book.getItem().getIsbn())) {
                pair.setQuantity(pair.getQuantity() + book.getQuantity());
                return;
            }
        }
        books.add(book);
    }

    public void addOther(Pair<Other, Integer> other) {
        for(Pair<Other, Integer> pair : others) {
            if(pair.getItem().getBarcode().equals(other.getItem().getBarcode())) {
                pair.setQuantity(pair.getQuantity() + other.getQuantity());
                return;
            }
        }
        others.add(other);
    }

    public double getBookStorePrice() {
        double price = 0;
        for(Pair<Book, Integer> pair : books) {
            price += pair.getItem().getPrice() * pair.getQuantity();
        }
        for(Pair<Other, Integer> pair : others) {
            price += pair.getItem().getPrice() * pair.getQuantity();
        }
        return price;
    }

    public Item getCheapestItem() {
        Item cheapest = null;
        for(Pair<Book, Integer> pair : books) {
            if(cheapest == null || pair.getItem().getPrice() < cheapest.getPrice()) {
                cheapest = pair.getItem();
            }
        }
        for(Pair<Other, Integer> pair : others) {
            if(cheapest == null || pair.getItem().getPrice() < cheapest.getPrice()) {
                cheapest = pair.getItem();
            }
        }
        return cheapest;
    }

    public Map<String, List<Book>> getBooksByAuthor(){
        Map<String, List<Book>> map = new HashMap<>();
        for(Pair<Book, Integer> pair : books) {
            if(map.containsKey(pair.getItem().getAuthor())) {
                map.get(pair.getItem().getAuthor()).add(pair.getItem());
            } 
            else {
                List<Book> list = new ArrayList<>();
                list.add(pair.getItem());
                map.put(pair.getItem().getAuthor(), list);
            }
        }
        return map;
    }

    public Book getBook(String isbn) {
        for(Pair<Book, Integer> pair : books) {
            if(pair.getItem().getIsbn().equals(isbn)) {
                return pair.getItem();
            }
        }
        throw new IllegalArgumentException("No book with the given isbn exists");
    }

    public Other getOther(String barcode) {
        for(Pair<Other, Integer> pair : others) {
            if(pair.getItem().getBarcode().equals(barcode)) {
                return pair.getItem();
            }
        }
        throw new IllegalArgumentException("No other item with the given barcode exists");
    }
}