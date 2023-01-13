package main;

public class App {
    public static int main(String[] args) throws Exception {
        try{
            System.out.println("Hello, World!");
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }
}
