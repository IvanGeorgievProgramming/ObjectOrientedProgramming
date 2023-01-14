package main;

import main.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            boolean isProgramRunning = true;
            
            while(isProgramRunning){
                printMenu();

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                switch(choice){
                    case 1:
                        System.out.println("Login");
                        break;
                    case 2:
                        System.out.println("Logout");
                        break;
                    case 3:
                        System.out.println("Register");
                        break;
                    case 4:
                        System.out.println("Add Address");
                        break;
                    case 5:
                        System.out.println("Add Order");
                        break;
                    case 6:
                        System.out.println("Add Package");
                        break;
                    case 7:
                        System.out.println("Get Random Order To Deliver");
                        break;
                    case 8:
                        System.out.println("Get Order To Deliver");
                        break;
                    case 9:
                        System.out.println("Deliver Order");
                        break;
                    case 10:
                        System.out.println("Exit");
                        isProgramRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void printMenu(){
        System.out.println("1. Login");
        System.out.println("2. Logout");
        System.out.println("3. Register");
        System.out.println("4. Add Address");
        System.out.println("5. Add Order");
        System.out.println("6. Add Package");
        System.out.println("7. Get Random Order To Deliver");
        System.out.println("8. Get Order To Deliver");
        System.out.println("9. Deliver Order");
        System.out.println("10. Exit");
    }
}
