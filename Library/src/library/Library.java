package library;

import book.Book;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public Library(ArrayList<Book> books) {
        if(books == null){
            books = new ArrayList<Book>();
        }
        else if(books.size() > 5000){
            throw new IllegalArgumentException("The library can have up to 5000 books.");
        }
        else if(books.size() < 3){
            throw new IllegalArgumentException("The library must have at least 3 books.");
        }
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public String toString() {
        return "Library [books=" + books + "]";
    }

    public void printAllBooksById(){
        for (Book book : books) {
            System.out.println(book.getId() + " " + book.getTitle() + " " + book.getAuthorInitials() + " " + book.getPrice() + " " + book.getQuantity() + " " + book.getTotalPrice());
        }
    }

    public void printAllBooksByLowestTotalPrice(){
        ArrayList<Book> sortedBooks = new ArrayList<Book>();
        sortedBooks.addAll(books);
        sortedBooks.sort((b1, b2) -> Double.compare(b1.getTotalPrice(), b2.getTotalPrice()));

        for (Book book : sortedBooks) {
            System.out.println(book.getId() + " " + book.getTitle() + " " + book.getAuthorInitials() + " " + book.getPrice() + " " + book.getQuantity() + " " + book.getTotalPrice());
        }
    }

    public void printAuthorsWithBooksAboveAveragePrice(){
        double averagePrice = 0;

        for (Book book : books) {
            averagePrice += book.getPrice();
        }

        averagePrice /= books.size();
        ArrayList<String> authors = new ArrayList<String>();

        for (Book book : books) {
            if(book.getPrice() > averagePrice){
                if(!authors.contains(book.getAuthor())){
                    authors.add(book.getAuthor());
                }
            }
        }
        System.out.println("Average price: " + averagePrice);
        System.out.println("Authors with books above average price: " + authors);
    }
}