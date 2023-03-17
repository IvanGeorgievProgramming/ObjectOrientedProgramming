package book;

public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private int quantity;
    private double totalPrice;
    private static int idCounter = 0;

    public Book(String title, String author, double price, int quantity) {
        if(title == null || title.length() > 100){
            throw new IllegalArgumentException("The title must be a string not longer than 100 characters.");
        }
        if(author == null || author.length() > 80){
            throw new IllegalArgumentException("The author must be a string not longer than 80 characters.");
        }
        if(price < 1.00 || price > 99.99){
            throw new IllegalArgumentException("The price must be a real number in the interval [1.00;99.99].");
        }
        if(quantity < 1 || quantity > 50){
            throw new IllegalArgumentException("The quantity must be an integer in the interval [1;50].");
        }
        this.id = idCounter;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = price * quantity;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAuthorInitials() {
        String[] authorNames = author.split(" ");
        String authorInitials = "";

        authorInitials += authorNames[authorNames.length - 1];

        for (int i = 0; i < authorNames.length - 1; i++) {
            authorInitials += " " + authorNames[i].charAt(0) + ".";
        }

        return authorInitials;
    }

    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", quantity=" + quantity + "]";
    }
}
