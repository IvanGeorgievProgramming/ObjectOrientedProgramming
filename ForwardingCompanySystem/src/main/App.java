package main;

import main.user.*;
import main.order.*;
import main.ppackages.*;
import main.address.*;
import main.deliverysystem.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            boolean isProgramRunning = true;
            DeliverySystem deliverySystem = new DeliverySystem();

            while(isProgramRunning){

                printMenu();

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                scanner.close();

                switch(choice){
                    case 1:
                        System.out.println("Login: \n");
                        logInM(deliverySystem);
                        break;
                    case 2:
                        System.out.println("Logout \n");
                        logOut(deliverySystem);
                        break;
                    case 3:
                        System.out.println("Register \n");
                        register(deliverySystem);
                        break;
                    case 4:
                        System.out.println("Add Address \n");
                        addAddress(deliverySystem);
                        break;
                    case 5:
                        System.out.println("Add Order \n");
                        addOrder(deliverySystem);
                        break;
                    case 6:
                        System.out.println("Add Package \n");
                        addPackage(deliverySystem);
                        break;
                    case 7:
                        System.out.println("Get Random Order To Deliver \n");
                        getRandomOrderToDeliver(deliverySystem);
                        break;
                    case 8:
                        System.out.println("Get Order To Deliver \n");
                        getOrderToDeliver(deliverySystem);
                        break;
                    case 9:
                        System.out.println("Deliver Order \n");
                        deliverOrder(deliverySystem);
                        break;
                    case 10:
                        System.out.println("Exit \n");
                        isProgramRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice \n");
                        break;
                }
            }
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void printCurrentUser(User currentUser){
        // If there is no current user, print "No current user"
        if(currentUser == null){
            System.out.println("No current user");
            return;
        }
        System.out.println("Current User: " + currentUser);
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

    public static void logInM(DeliverySystem deliverySystem){
        if(deliverySystem.getCurrentUser() != null){
            System.out.println("You are already logged in\n");
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

    public static void logOut(DeliverySystem deliverySystem){
        if(deliverySystem.getCurrentUser() == null){
            System.out.println("You are not logged in\n");
            return;
        }

        deliverySystem.logout();
    }

    public static void register(DeliverySystem deliverySystem){
        if(deliverySystem.getCurrentUser() != null){
            System.out.println("You are already logged in\n");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        System.out.println("Choose role: ");
        System.out.println("1. CUSTOMER");
        System.out.println("2. DRIVER\n");
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

    public static void addAddress(DeliverySystem deliverySystem){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter country: ");
        String country = scanner.nextLine();

        System.out.println("Enter city: ");
        String city = scanner.nextLine();

        System.out.println("Enter street: ");
        String street = scanner.nextLine();

        System.out.println("Enter User Id: ");
        int userId = scanner.nextInt();

        scanner.close();

        Address address = new Address(country, city, street, userId);
        deliverySystem.addAddress(address);
    }

    public static void addOrder(DeliverySystem deliverySystem){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Address Id: ");
        int addressId = scanner.nextInt();

        scanner.close();

        Order order = new Order(addressId);

        System.out.println("How many packages do you want to add? ");
        int numberOfPackages = scanner.nextInt();

        if(numberOfPackages < 1){
            System.out.println("Invalid number of packages");
            return;
        }

        for(int i = 0; i < numberOfPackages; i++){
            System.out.println("Choose package type: ");
            System.out.println("1. Salable");
            System.out.println("2. Not Salable\n");
            int packageType = scanner.nextInt();

            System.out.println("Choose size: ");
            System.out.println("1. SMALL");
            System.out.println("2. MEDIUM");
            System.out.println("3. BIG\n");
            int size = scanner.nextInt();

            if(packageType == 1){
                if(size == 1){
                    System.out.println("Enter package size: ");
                    int packageSize = scanner.nextInt();

                    System.out.println("Enter price: ");
                    double price = scanner.nextDouble();

                    SmallSizePPackage smallPackage = new SmallSizePPackage(packageSize);
                    SalablePPackage salablePackage = new SalablePPackage(price, smallPackage);

                    order.addPackage(salablePackage);
                }
                else if(size == 2){
                    System.out.println("Enter package size: ");
                    int packageSize = scanner.nextInt();

                    System.out.println("Enter price: ");
                    double price = scanner.nextDouble();

                    MediumSizePPackage mediumPackage = new MediumSizePPackage(packageSize);
                    SalablePPackage salablePackage = new SalablePPackage(price, mediumPackage);

                    order.addPackage(salablePackage);
                }
                else if(size == 3){
                    System.out.println("Enter package size: ");
                    int packageSize = scanner.nextInt();

                    System.out.println("Enter price: ");
                    double price = scanner.nextDouble();

                    BigSizePPackage bigPackage = new BigSizePPackage(packageSize);
                    SalablePPackage salablePackage = new SalablePPackage(price, bigPackage);

                    order.addPackage(salablePackage);
                }
                else{
                    System.out.println("Invalid size");
                }
            }
            else if(packageType == 2){
                if(size == 1){
                    System.out.println("Enter package size: ");
                    int packageSize = scanner.nextInt();

                    SmallSizePPackage smallPackage = new SmallSizePPackage(packageSize);

                    order.addPackage(smallPackage);
                }
                else if(size == 2){
                    System.out.println("Enter package size: ");
                    int packageSize = scanner.nextInt();

                    MediumSizePPackage mediumPackage = new MediumSizePPackage(packageSize);

                    order.addPackage(mediumPackage);
                }
                else if(size == 3){
                    System.out.println("Enter package size: ");
                    int packageSize = scanner.nextInt();

                    BigSizePPackage bigPackage = new BigSizePPackage(packageSize);

                    order.addPackage(bigPackage);
                }
                else{
                    System.out.println("Invalid size");
                }
            }
            else{
                System.out.println("Invalid package type");
            }
        }

        deliverySystem.addOrder(order);
    }

    public static void addPackage(DeliverySystem deliverySystem){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Order Id: ");
        int orderId = scanner.nextInt();

        System.out.println("Choose package type: ");
        System.out.println("1. Salable");
        System.out.println("2. Not Salable\n");
        int packageType = scanner.nextInt();

        System.out.println("Choose size: ");
        System.out.println("1. SMALL");
        System.out.println("2. MEDIUM");
        System.out.println("3. BIG\n");
        int size = scanner.nextInt();

        if(packageType == 1){
            if(size == 1){
                System.out.println("Enter package size: ");
                int packageSize = scanner.nextInt();

                System.out.println("Enter price: ");
                double price = scanner.nextDouble();

                // Create a new small package
                SmallSizePPackage smallPackage = new SmallSizePPackage(packageSize);
                // Create a new salable package
                SalablePPackage salablePackage = new SalablePPackage(price, smallPackage);

                deliverySystem.addPackage(salablePackage, orderId);
            }
            else if(size == 2){
                System.out.println("Enter package size: ");
                int packageSize = scanner.nextInt();

                System.out.println("Enter price: ");
                double price = scanner.nextDouble();

                // Create a new medium package
                MediumSizePPackage mediumPackage = new MediumSizePPackage(packageSize);
                // Create a new salable package
                SalablePPackage salablePackage = new SalablePPackage(price, mediumPackage);

                deliverySystem.addPackage(salablePackage, orderId);
            }
            else if(size == 3){
                System.out.println("Enter package size: ");
                int packageSize = scanner.nextInt();

                System.out.println("Enter price: ");
                double price = scanner.nextDouble();

                // Create a new big package
                BigSizePPackage bigPackage = new BigSizePPackage(packageSize);
                // Create a new salable package
                SalablePPackage salablePackage = new SalablePPackage(price, bigPackage);

                deliverySystem.addPackage(salablePackage, orderId);
            }
            else{
                System.out.println("Invalid size");

            }
        }
        else if(packageType == 2){
            if(size == 1){
                System.out.println("Enter package size: ");
                int packageSize = scanner.nextInt();

                // Create a new small package
                SmallSizePPackage smallPackage = new SmallSizePPackage(packageSize);

                deliverySystem.addPackage(smallPackage, orderId);
            }
            else if(size == 2){
                System.out.println("Enter package size: ");
                int packageSize = scanner.nextInt();

                // Create a new medium package
                MediumSizePPackage mediumPackage = new MediumSizePPackage(packageSize);

                deliverySystem.addPackage(mediumPackage, orderId);
            }
            else if(size == 3){
                System.out.println("Enter package size: ");
                int packageSize = scanner.nextInt();

                // Create a new big package
                BigSizePPackage bigPackage = new BigSizePPackage(packageSize);

                deliverySystem.addPackage(bigPackage, orderId);
            }
            else{
                System.out.println("Invalid size");
            }
        }
        else{
            System.out.println("Invalid package type");
        }

        scanner.close();

    }

    public static void getRandomOrderToDeliver(DeliverySystem deliverySystem){
        //...
    }

    public static void getOrderToDeliver(DeliverySystem deliverySystem){
        //...
    }

    public static void deliverOrder(DeliverySystem deliverySystem){
        //...
    }
}
