package Pizzeria;

import java.util.ArrayList;
import java.util.List;

import Pizzeria.Pizza;
import Pizzeria.Product;

public class Oven {
    private List<Pizza> pizzas;
    private List<Product> products;

    public Oven() {
        this.pizzas = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public synchronized void addPizza(Pizza pizza) {
        pizzas.add(pizza);
        notify();
    }

    public synchronized void addProduct(Product product) {
        products.add(product);
        notify(); 
    }

    public synchronized Pizza getPizza() throws InterruptedException {
        while (pizzas.isEmpty()) {
            wait(); 
        }
        return pizzas.remove(0); 
    }

    public synchronized Product getProduct() throws InterruptedException {
        while (products.isEmpty()) {
            wait(); 
        }
        return products.remove(0); // Get and remove the first product in the list
    }
}