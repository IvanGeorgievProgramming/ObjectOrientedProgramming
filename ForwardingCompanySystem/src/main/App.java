package main;

import main.address.*;
import main.deliverysystem.*;
import main.order.*;
import main.ppackages.*;
import main.user.*;


import java.util.Scanner;
import java.util.Collection;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            boolean isProgramRunning = true;

            // Make an empty collection of users
            Collection<User> users = new ArrayList<User>();

            // Make an empty collection of addresses
            Collection<Address> addresses = new ArrayList<Address>();

            // Make an empty collection of orders
            Collection<Order> orders = new ArrayList<Order>();

            // Make a current user
            User currentUser = null;

            // Make a delivery system
            DeliverySystem deliverySystem = new DeliverySystem(users, orders, addresses, currentUser);

            while(isProgramRunning){

                deliverySystem.printDeliverySystem();
                printMenu();

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                switch(choice){
                    case 1:
                        System.out.println("Login");
                        //login(deliverySystem);
                        break;
                    case 2:
                        System.out.println("Logout");
                        //logout(deliverySystem);
                        break;
                    case 3:
                        System.out.println("Register");
                        //register(deliverySystem);
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
        System.out.println("\n1. Login");
        System.out.println("2. Logout");
        System.out.println("3. Register");
        System.out.println("4. Add Address");
        System.out.println("5. Add Order");
        System.out.println("6. Add Package");
        System.out.println("7. Get Random Order To Deliver");
        System.out.println("8. Get Order To Deliver");
        System.out.println("9. Deliver Order");
        System.out.println("10. Exit\n");
    }

    public static void login(DeliverySystem deliverySystem){
        if(deliverySystem.getCurrentUser() != null){
            System.out.println("You are already logged in");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        scanner.close();

        deliverySystem.login(username, password);
    }

    public static void logout(DeliverySystem deliverySystem){
        if(deliverySystem.getCurrentUser() == null){
            System.out.println("You are already logged out");
            return;
        }

        deliverySystem.logout();
    }

    public static void register(DeliverySystem deliverySystem){
        if(deliverySystem.getCurrentUser() != null){
            System.out.println("You are already logged in");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        System.out.println("Enter Role: ");
        System.out.println("1. Customer");
        System.out.println("2. Driver");
        int role = scanner.nextInt();

        scanner.close();

        if(role == 1){
            deliverySystem.registerUser(username, password);
        }
        else if(role == 2){
            deliverySystem.registerDriver(username, password);
        }
        else{
            System.out.println("Invalid role");
        }
    }
}