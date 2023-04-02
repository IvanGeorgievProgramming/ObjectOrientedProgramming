import java.util.Map;
import java.util.HashMap;	
import java.util.Scanner;

import donerKebabShop.DonerKebabShop;
import kebabSkewer.KebabSkewer;
import donerMaker.DonerMaker;
import helper.Helper;

public class App {
    public static void main(String[] args) {
        // Initialize DonerKebabShop, DonerMaker, and Helper instances
        DonerKebabShop donerKebabShop = new DonerKebabShop(1000, Map.of("lettuce", 200, "tomato", 200));
        DonerMaker[] donerMakers = {new DonerMaker(donerKebabShop, donerKebabShop.getProducts()), new DonerMaker(donerKebabShop, donerKebabShop.getProducts())};
        Helper[] helpers = {new Helper(donerKebabShop), new Helper(donerKebabShop)};
        
        // Start Helper threads
        for (Helper helper : helpers) {
            new Thread(helper).start();
        }
        
        // Start reading orders from the console
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Read an order from the console
            System.out.print("Enter an order (e.g. meat:200;lettuce:100): ");
            String orderString = sc.nextLine();
            
            // Parse the order string into a Map of ingredients and amounts
            String[] orderParts = orderString.split(";");
            Map<String, Integer> order = new HashMap<>();
            for (String part : orderParts) {
                String[] ingredientAndAmount = part.split(":");
                String ingredient = ingredientAndAmount[0];
                int amount = Integer.parseInt(ingredientAndAmount[1]);
                order.put(ingredient, amount);
            }
            
            // Assign the order to the first available DonerMaker
            for (DonerMaker donerMaker : donerMakers) {
                if (donerMaker.getIsAvailable()) {
                    donerMaker.assignOrder(order);
                    break;
                }
            }
        }
    }
}
