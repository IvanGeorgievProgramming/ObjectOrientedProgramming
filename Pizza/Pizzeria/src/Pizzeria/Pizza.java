package Pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private List<Product> ingredients;
    private int preparationTime;

    public Pizza(List<Product> ingredients) {
        this.ingredients = ingredients;
        this.preparationTime = 0;
        for(Product p : ingredients) {
            this.preparationTime += p.getCookingTime();
        }
    }

    public List<Product> getIngredients() {
        return ingredients;
    }

    public int getPreparationTime() {
        return preparationTime;
    }
}
