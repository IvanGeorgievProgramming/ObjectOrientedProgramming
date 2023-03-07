package main.pair;

import main.item.Item;

public class Pair <Item, Integer> {

    // * Parameters

    private Item item;
    private Integer quantity;

    // * Constructors

    public Pair(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // * Getters

    public Item getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    // * Setters

    public void setItem(Item item) {
        this.item = item;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // * Methods

    public void print() {
        System.out.println("Pair:");
        System.out.println("Item: " + item);
        //this.item.print();
        System.out.println("Quantity: " + quantity);
        System.out.println();
    }
}

/*
Pair
Implement a Pair class that has 2 two elements. The first can be Book or Other, and the second is an integer that is greater than or equal to 0. The pair represents an item in the bookstore and its quantity.
There are 2 methods:
getFirst() - returns the item(Book or Other)
getSecond() - returns the quantity.
*/