import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Pizzeria.Oven;
import Pizzeria.Pizza;
import Pizzeria.PizzaMaker;
import Pizzeria.Product;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Oven oven = new Oven();
        List<PizzaMaker> pizzaMakers = new ArrayList<>();
        Map<String, Product> products = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(", ");

            switch (tokens[0]) {
                case "HirePizzaMan":
                    String firstName = tokens[1];
                    String lastName = tokens[2];
                    int experience = Integer.parseInt(tokens[3]);
                    pizzaMakers.add(new PizzaMaker(firstName, lastName, experience, oven));
                    break;
                case "Stove":
                    int capacity = Integer.parseInt(tokens[1]);
                    oven = new Oven();
                    for (int i = 0; i < capacity; i++) {
                        pizzaMakers.get(i).setOven(oven);
                    }
                    break;
                case "Ingredient":
                    String name = tokens[1];
                    String type = tokens[2];
                    if (products.containsKey(name)) {
                        System.out.println("Error: The ingredient already exists!");
                    } else {
                        products.put(name, new Product(name, type));
                    }
                    break;
                case "Order":
                    int id = Integer.parseInt(tokens[1]);
                    List<Product> ingredients = new ArrayList<>();
                    for (int i = 2; i < tokens.length; i++) {
                        if (products.containsKey(tokens[i])) {
                            ingredients.add(products.get(tokens[i]));
                        } else {
                            System.out.println("Error: The ingredient does not exist!");
                            break;
                        }
                    }
                    if (ingredients.size() == tokens.length - 2) {
                        Pizza pizza = new Pizza(ingredients);
                        oven.addPizza(pizza);
                        System.out.println("Order " + id + " is ready!");
                    } else {
                        System.out.println("Order " + id + " is not ready!");
                    }
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}