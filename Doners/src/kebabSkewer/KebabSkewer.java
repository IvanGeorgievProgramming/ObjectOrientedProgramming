package kebabSkewer;

import donerKebabShop.DonerKebabShop;

public class KebabSkewer implements Runnable {
    private DonerKebabShop donerKebabShop;

    public KebabSkewer(DonerKebabShop donerKebabShop) {
        this.donerKebabShop = donerKebabShop;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 4000) + 1000);
                this.donerKebabShop.addMeat(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*

KebabSkewer takes care to produce meat. At random intervals between 1 and 5 seconds, the spit produces 100 units of meat. 
Adding the meat to the shisha is done by calling the addMeat method. If the meat is already at maximum, 
then the skewer stops producing until it is notified that meat has been used.

*/