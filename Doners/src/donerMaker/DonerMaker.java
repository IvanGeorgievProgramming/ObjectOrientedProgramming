package donerMaker;

import java.util.Map;
import donerKebabShop.DonerKebabShop;

public class DonerMaker implements Runnable {
    private DonerKebabShop kebabShop;
    private Map<String, Integer> ingredients;
    private boolean isAvailable;
    
    public DonerMaker(DonerKebabShop kebabShop, Map<String, Integer> ingredients) {
        this.kebabShop = kebabShop;
        this.ingredients = ingredients;
        this.isAvailable = true;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setIngredients(Map<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public void assignOrder(Map<String, Integer> ingredients) {
        this.setIngredients(ingredients);
        this.setIsAvailable(false);
        // Run the thread
        new Thread(this).start();
    }

    public void run() {
        // Get the amount of meat needed
        int meatAmount = ingredients.getOrDefault("meat", 0);
            
        // Use the required amount of meat
        synchronized (kebabShop) {
            while (kebabShop.getCurrentMeat() < meatAmount) {
                try {
                    kebabShop.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            kebabShop.useMeat(meatAmount);
        }

        // Use the required amount of vegetables
        for (String ingredient : ingredients.keySet()) {
            if (!ingredient.equals("meat")) {
                int vegetableAmount = ingredients.getOrDefault(ingredient, 0);
                kebabShop.useVegetable(ingredient, vegetableAmount);
            }
        }

        // // Notify the helpers that the vegetables are low
        // kebabShop.notifyHelpers();
        
        // Print the order
        System.out.println("Doner made with " + ingredients);
    }
}

/*

DonerMaker takes care of making the duners. He gets a Map<String, Integer> with the ingredients and their quantity for a given doner. 
The meat is "meat", everything else is vegetables. 
The DonerMaker prepares the doner by calling the DonerKebabShop's useMeat and useVegetable methods. 
If there is not enough meat, he waits until the meat is loaded and then continues with making the duner. 
The same goes for vegetables, if it notices that a vegetable has less than 10% of the maximum capacity left, then it notifies the helpers.

*/