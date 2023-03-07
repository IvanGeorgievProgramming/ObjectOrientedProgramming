package main.item.book;

public class Book extends main.item.Item {

    // * Parameters

    private String isbn;
    private String author;
    private String name;
    private String description;

    // * Constructors

    public Book(String isbn, String author, String name, String description, double price) {
        super(price);
        if(isbn.length() != 13 && isbn.length() != 10)
            throw new IllegalArgumentException("ISBN must be 13 or 10 digits long");
        this.isbn = isbn;
        this.author = author;
        this.name = name;
        this.description = description;
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

    // * Methods

    @Override
    public void print() {
        System.out.println("    Book:");
        System.out.println("    ISBN: " + isbn);
        System.out.println("    Author: " + author);
        System.out.println("    Name: " + name);
        System.out.println("    Description: " + description);
        System.out.println("    Price: " + this.getPrice());
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