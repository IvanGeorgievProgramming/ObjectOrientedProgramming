package Pizzeria;

import java.util.ArrayList;
import java.util.List;

import Pizzeria.Oven;

public class PizzaMaker implements Runnable {
    private String firstName;
    private String lastName;
    private int yearsOfExperience;
    private List<Oven> ovens;
    private List<Product> ingredients;
    private int preparationTime;

    public PizzaMaker(String firstName, String lastName, int yearsOfExperience, Oven oven) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsOfExperience = yearsOfExperience;
        this.ovens = new ArrayList<>();
        this.ingredients = new ArrayList<>();
        this.preparationTime = 0;
    }

    public void addIngredient(Product ingredient) {
        this.ingredients.add(ingredient);
    }

    public void setOven(Oven oven) {
        this.ovens.add(oven);
    }

    public void run() {
        if (yearsOfExperience >= 0 && yearsOfExperience <= 3) {
            this.preparationTime = ingredients.size() * 1000;
        } else if (yearsOfExperience >= 4 && yearsOfExperience <= 8) {
            this.preparationTime = (int) (ingredients.size() * 0.5 * 1000);
        } else if (yearsOfExperience >= 9) {
            this.preparationTime = (int) (ingredients.size() * 0.3 * 1000);
        }

        System.out.println("Pizza maker " + firstName + " " + lastName + " is preparing the pizza...");
        try {
            Thread.sleep(preparationTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Pizza maker " + firstName + " " + lastName + " finished preparing the pizza.");
        ovens.get(0).addPizza(new Pizza(ingredients));
    }
}