package main.deliverysystem;

import main.user.*;
import main.order.*;
import main.ppackages.*;
import main.address.*;

import java.util.Collection;

public class DeliverySystem {
    
    // * Variables
    
    private final int id;
    private Collection<User> users;
    private Collection<Order> orders;
    private Collection<Address> addresses;
    private User currentUser;

    private static int idCounter = 0;

    // * Constructors

    public DeliverySystem() {
        this.id = idCounter++;
        this.users = null;
        this.orders = null;
        this.addresses = null;
        this.currentUser = null;
    }

    public DeliverySystem(Collection<User> users, Collection<Order> orders, Collection<Address> addresses, User currentUser) {
        this.id = idCounter++;
        this.users = users;
        this.orders = orders;
        this.addresses = addresses;
        this.currentUser = currentUser;

        registerAdmin("admin", "admin123");

        this.currentUser = this.users.iterator().next();
    }

    public DeliverySystem(DeliverySystem deliverySystem) {
        this.id = deliverySystem.id;
        this.users = deliverySystem.users;
        this.orders = deliverySystem.orders;
        this.addresses = deliverySystem.addresses;
        this.currentUser = deliverySystem.currentUser;
    }

    // * Getters

    public int getId() {
        return id;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    // * Setters

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    // * Methods

    public void printDeliverySystem() {
        // Print the Delivery system Id
        System.out.println("\nDelivery System Id: " + id);

        // Print the users
        System.out.println("Users: ");
        if(users == null) {
            System.out.println("No current users");
        }
        else{
            for (User user : users) {
                System.out.println("    Id: " + user.getId());
                System.out.println("    Name: " + user.getName());
                System.out.println("    Password: " + user.getPassword());
                System.out.println("    Role: " + user.getRole());
            }
        }

        // Print the orders
        System.out.println("Orders: ");
        if(orders == null) {
            System.out.println("No current orders");
        }
        else{
            for (Order order : orders) {
                System.out.println("    Id: " + order.getId());

                if(order.getPPackages() == null) {
                    System.out.println("        No current packages");
                }
                else{
                    for (PPackage pPackage : order.getPPackages()) {
                        System.out.println("        Package Id: " + pPackage.getId());
                    }
                }

                System.out.println("        Address Id: " + order.getAddressId());

                if(order.getStatus() == null) {
                    System.out.println("        No current status");
                }
                else{
                    System.out.println("        Status: " + order.getStatus());
                }
            }
        }

        // Print the addresses
        System.out.println("Addresses: ");
        if(addresses == null) {
            System.out.println("    No current addresses");
        }
        else{
            for (Address address : addresses) {
                System.out.println("    Id: " + address.getId());
                System.out.println("    Country: " + address.getCountry());
                System.out.println("    City: " + address.getCity());
                System.out.println("    Street: " + address.getStreet());
                System.out.println("    User Id: " + address.getUserId());
            }
        }

        // Print the current user
        System.out.println("Current User: ");
        if(currentUser == null) {
            System.out.println("    No current user");
        }
        else{
            System.out.println("    Id: " + currentUser.getId());
            System.out.println("    Name: " + currentUser.getName());
            System.out.println("    Password: " + currentUser.getPassword());
            System.out.println("    Role: " + currentUser.getRole());
        }
    }

    public void login(String name, String password) {
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                currentUser.setName(user.getName());
                currentUser.setPassword(user.getPassword());
                currentUser.setRole(user.getRole());
                return;
            }
        }

        throw new IllegalArgumentException("Invalid username or password");
    }

    public void logout() {
        currentUser = null;
    }

    public void registerAdmin(String name, String password) {
        // If there is already an admin, throw an exception
        for (User user : users) {
            if (user.getRole() == Role.ADMINISTRATOR) {
                throw new IllegalArgumentException("There is already an admin");
            }
        }

        users.add(new User(name, password, Role.ADMINISTRATOR));
    }

    public void registerUser(String name, String password) {
        // If there is already a user with the same name, throw an exception
        for (User user : users) {
            if (user.getName().equals(name)) {
                throw new IllegalArgumentException("There is already a user with the same name");
            }
        }

        // If the current user is not an admin, throw an exception
        if (currentUser.getRole() != Role.ADMINISTRATOR) {
            throw new IllegalArgumentException("Only an admin can register a user");
        }

        users.add(new User(name, password, Role.CUSTOMER));
    }

    public void registerDriver(String name, String password) {
        // If there is already a driver with the same name, throw an exception
        for (User user : users) {
            if (user.getName().equals(name)) {
                throw new IllegalArgumentException("There is already a driver with the same name");
            }
        }

        // If the current user is not an admin, throw an exception
        if (currentUser.getRole() != Role.ADMINISTRATOR) {
            throw new IllegalArgumentException("Only an admin can register a driver");
        }

        users.add(new User(name, password, Role.DRIVER));
    }

    public void addAddress(Address address){
        // If the current user is not a customer, throw an exception
        if (currentUser.getRole() != Role.CUSTOMER) {
            throw new IllegalArgumentException("Only a customer can add an address");
        }

        // If UserId is not the same as the current user, throw an exception
        if (address.getUserId() != currentUser.getId()) {
            throw new IllegalArgumentException("The address does not belong to the current user");
        }

        addresses.add(address);
    }

    public void addOrder(Order order){
        // If the current user is not a customer, throw an exception
        if (currentUser.getRole() != Role.CUSTOMER) {
            throw new IllegalArgumentException("Only a customer can add an order");
        }

        //TODO: If the address does not belong to the current user, throw an exception
        //TODO: If there is no address with the given id, throw an exception
        //TODO: If there is no package with the given id, throw an exception
        
        order.setStatus(Status.CREATED);
        orders.add(order);
    }

    public void addPackage(PPackage pPackage, int orderId){
        // If the current user is not a customer, throw an exception
        if (currentUser.getRole() != Role.CUSTOMER) {
            throw new IllegalArgumentException("Only a customer can add a package");
        }

        //If there is no order with the given id, throw an exception
        boolean found = false;
        for(Order order : orders){
            if(order.getId() == orderId){
                found = true;
                break;
            }
        }
        if(!found){
            throw new IllegalArgumentException("There is no order with the given id");
        }

        //TODO: If the address does not belong to the current user, throw an exception

        // Add a package to an order
        for(Order order : orders){
            if(order.getId() == orderId){
                order.getPPackages().add(pPackage);
                break;
            }
        }
    }

    public void getOrderToDeliver(){
        int random = 0;
        boolean found = false;
        do{
            random = (int) (Math.random() * orders.size());
            for(Order order : orders){
                if(order.getId() == random){
                    found = true;
                    break;
                }
            }
        }
        while(found);

        getOrderToDeliver(random);
    }

    public void getOrderToDeliver(int id){
        // If there is no order with the given id, throw an exception
        boolean found = false;
        for(Order order : orders){
            if(order.getId() == id){
                found = true;
                break;
            }
        }
        if(!found){
            throw new IllegalArgumentException("There is no order with the given id");
        }

        // If the current user is not a driver, throw an exception
        if (currentUser.getRole() != Role.DRIVER) {
            throw new IllegalArgumentException("Only a driver can get an order to deliver");
        }

        // If the order is without status CREATED, throw an exception
        for(Order order : orders){
            if(order.getId() == id){
                if(order.getStatus() != Status.CREATED){
                    throw new IllegalArgumentException("The order is not available");
                }
                else{
                    order.setStatus(Status.DELIVERING);
                    break;
                }
            }
        }
    }

    public void deliverOrder(int id){
        // If there is no order with the given id, throw an exception
        boolean found = false;
        for(Order order : orders){
            if(order.getId() == id){
                found = true;
                break;
            }
        }
        if(!found){
            throw new IllegalArgumentException("There is no order with the given id");
        }

        // If the current user is not a driver, throw an exception
        if (currentUser.getRole() != Role.DRIVER) {
            throw new IllegalArgumentException("Only a driver can deliver an order");
        }

        // If the order is without status DELIVERING, throw an exception
        for(Order order : orders){
            if(order.getId() == id){
                if(order.getStatus() != Status.DELIVERING){
                    throw new IllegalArgumentException("The order is not available");
                }
                else{
                    order.setStatus(Status.DELIVERED);
                    break;
                }
            }
        }
    }
}
