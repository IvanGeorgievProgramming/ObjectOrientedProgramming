package donerKebabShop;

import java.util.Map;
import java.util.HashMap;

public class DonerKebabShop {
    private int maxMeat;
    private int currentMeat;
    private Map<String, Integer> maxVegetables;
    private Map<String, Integer> currentVegetables;

    public int getCurrentMeat() {
        return this.currentMeat;
    }

    public int getCurrentVegetableAmount(String vegetable) {
        return this.currentVegetables.get(vegetable);
    }

    public int getMaxVegetableAmount(String vegetable) {
        return this.maxVegetables.get(vegetable);
    }

    public Map<String, Integer> getVegetables() {
        return this.currentVegetables;
    }

    public DonerKebabShop(int maxMeat, Map<String, Integer> maxVegetables) {
        this.maxMeat = maxMeat;
        this.currentMeat = maxMeat;
        this.maxVegetables = maxVegetables;
        this.currentVegetables = new HashMap<>();
        for (Map.Entry<String, Integer> entry : maxVegetables.entrySet()) {
            String vegetable = entry.getKey();
            int maxQuantity = entry.getValue();
            this.currentVegetables.put(vegetable, maxQuantity);
        }
    }

    public synchronized void addMeat(int amount) {
        int newMeat = this.currentMeat + amount;
        if (newMeat > this.maxMeat) {
            this.currentMeat = this.maxMeat;
        } else {
            this.currentMeat = newMeat;
        }
    }

    public synchronized void addVegetable(String vegetable, int amount) {
        int currentQuantity = this.currentVegetables.getOrDefault(vegetable, 0);
        int maxQuantity = this.maxVegetables.get(vegetable);
        int newQuantity = currentQuantity + amount;
        if (newQuantity > maxQuantity) {
            newQuantity = maxQuantity;
        }
        this.currentVegetables.put(vegetable, newQuantity);
    }

    public synchronized String getVegetableThatNeedsLoading() {
        return this.currentVegetables.entrySet().stream()
                .filter(entry -> entry.getValue() < 0.1 * entry.getValue())
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public synchronized boolean useMeat(int amount) {
        if (this.currentMeat >= amount) {
            this.currentMeat -= amount;
            return true;
        } else {
            return false;
        }
    }

    public synchronized boolean useVegetable(String vegetable, int amount) {
        int currentQuantity = this.currentVegetables.getOrDefault(vegetable, 0);
        if (currentQuantity >= amount) {
            this.currentVegetables.put(vegetable, currentQuantity - amount);
            return true;
        } else {
            return false;
        }
    }

    // Make a method that returns Map<String, Integer> with the current amount of meat and vegetables.
    public Map<String, Integer> getProducts() {
        Map<String, Integer> products = new HashMap<>();
        products.put("meat", this.currentMeat);
        for (Map.Entry<String, Integer> entry : this.currentVegetables.entrySet()) {
            String vegetable = entry.getKey();
            int quantity = entry.getValue();
            products.put(vegetable, quantity);
        }
        return products;
    }

    // Notify Helpers to run.
    // public synchronized void notifyHelpers() {
    //     notifyAll();
    // }

}

/*

DonerKebabShop has :
 - maxMeat - the maximum amount that can be in the diner at any given time. Integer.
 - currentMeat - current amount of meat. Integer.
 - Map<String, Integer> maxVegetables - key value representing the available vegetables and their maximum quantity.
 - Map<String, Integer> currentVegetables - key value representing the available vegetables and their current quantity.
 - Constructor with 2 parameters:
    maximum amount of meat
    products and their maximum quantity
When initialized, the diner is loaded to maximum.

Methods:
addMeat(int amount) - adds the available amount of meat. If the meat is at the maximum value, does not add. If the meat is below the maximum value, adds meat as much as is fed or up to the maximum capacity.
addVegetable(String vegetable, int amount) - as for meat, only for vegetable
getVegetableThatNeedsLoading() - returns a vegetable whose current amount is less than 10% of the maximum amount. Use stream to find the vegetable!
useMeat(int amount) - gets a meat with the specified amount.
useVegetable(String vegetable, int amount) - takes a vegetable with the specified amount.

*/