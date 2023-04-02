package helper;

import java.util.Random;
import donerKebabShop.DonerKebabShop;

public class Helper implements Runnable {
    private DonerKebabShop kebabShop;
    private Random random;

    public Helper(DonerKebabShop kebabShop) {
        this.kebabShop = kebabShop;
        this.random = new Random();
    }

    public void run() {
        while (true) {
            String vegetable = kebabShop.getVegetableThatNeedsLoading();
            synchronized (kebabShop) {
                while (vegetable == null) {
                    try {
                        kebabShop.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vegetable = kebabShop.getVegetableThatNeedsLoading();
                }
                
                int currentAmount = kebabShop.getCurrentVegetableAmount(vegetable);
                int maxAmount = kebabShop.getMaxVegetableAmount(vegetable);
                int amountToAdd = random.nextInt(maxAmount - currentAmount + 1) + currentAmount;

                kebabShop.addVegetable(vegetable, amountToAdd);
                System.out.println(Thread.currentThread().getName() + " added " + amountToAdd + " " + vegetable);
            }
        }
    }
}

/*

Helpers load vegetables by first calling the getVegetableThatNeedsLoading method, 
then calling addVegetable for the vegetable returned by getVegetableThatNeedsLoading. 
If there is no vegetable that needs loading, the helper starts waiting until it is notified again that a vegetable needs loading. 
The amount of vegetable loaded is randomly between the current amount and the maximum.

*/