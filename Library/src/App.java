import java.util.ArrayList;
import library.Library;
import book.Book;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            ArrayList<Book> books = new ArrayList<Book>();

            books.add(new Book("The Lord of the Rings", "John Ronald Reuel Tolkien", 19.99, 5));
            books.add(new Book("The Hobbit", "John Ronald Reuel Tolkien", 19.99, 3));
            books.add(new Book("The Silmarillion", "John Ronald Reuel Tolkien", 29.99, 2));
            books.add(new Book("Harry Potter and the Philosopher's Stone", "Joanne Rowling", 9.99, 3));
            books.add(new Book("Harry Potter and the Chamber of Secrets", "Joanne Rowling", 9.99, 3));
            books.add(new Book("Harry Potter and the Prisoner of Azkaban", "Joanne Rowling", 9.99, 3));
            books.add(new Book("The Hunger Games", "Suzanne Collins", 9.99, 3));
            books.add(new Book("Catching Fire", "Suzanne Collins", 9.99, 3));

            Library library = new Library(books);

            library.printAllBooksById();
            System.out.println();

            library.printAllBooksByLowestTotalPrice();
            System.out.println();

            library.printAuthorsWithBooksAboveAveragePrice();
            System.out.println();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
