package Pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private String type;
    private int cookingTime;

    public Product(String name, String type) {
        this.name = name;
        this.type = type;
        this.cookingTime = getCookingTime();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCookingTime() {
        int pCookingTime = 0;

        switch (this.type) {
            case "Dough":
                pCookingTime += 2 * 1000;
                break;
            case "Sauce":
                pCookingTime += 1 * 1000;
                break;
            case "Vegetables":
                pCookingTime += 0.5 * 1000;
                break;
            case "Cheese":
                pCookingTime += 1 * 1000;
                break;
            case "Meat":
                pCookingTime += 1.5 * 1000;
                break;
            default:
                break;
        }

        return pCookingTime;
    }
}