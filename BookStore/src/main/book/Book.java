package main.book;

public class Book {

    // * Parameters

    private String isbn;
    private String author;
    private String name;
    private String description;
    private double price;

    // * Constructors

    public Book(String isbn, String author, String name, String description, double price) {
        if(isbn.length() != 13 && isbn.length() != 10)
            throw new IllegalArgumentException("ISBN must be 13 or 10 digits long");
        if(price <= 0)
            throw new IllegalArgumentException("Price must be greater than 0");
        this.isbn = isbn;
        this.author = author;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // * Getters

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    // * Setters

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // * Methods

    public void print() {
        System.out.println("Book:");
        System.out.println("ISBN: " + isbn);
        System.out.println("Author: " + author);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
        System.out.println();
    }

    // * Builder

    public static class BookBuilder {
        private String isbn;
        private String author;
        private String name;
        private String description;
        private double price;

        public BookBuilder(String isbn) {
            this.isbn = isbn;
        }

        public BookBuilder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BookBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public BookBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Book build() {
            return new Book(isbn, author, name, description, price);
        }
    }
}

/*
Book
String isbn - contains 13 or 10 numbers, required field, can start with 0. Unique identifier. Cannot be changed.
String author - author, optional field.
String name - book name, optional field.
String description - description of the book, optional field.
double price - price of the book, mandatory, greater than 0.
*/