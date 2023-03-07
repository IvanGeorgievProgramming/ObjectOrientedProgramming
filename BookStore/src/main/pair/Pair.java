package main.pair;

import main.item.Item;

public class Pair {

    // * Parameters

    private Item first;
    private int second;

    // * Constructors

    public Pair(Item first, int second) {
        if(second < 0)
            throw new IllegalArgumentException("Second must be greater than or equal to 0");
        this.first = first;
        this.second = second;
    }

    // * Getters

    public Item getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    // * Setters

    public void setFirst(Item first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    // * Methods

    public void print() {
        System.out.println("Pair:");
        System.out.println("First: " + first);
        this.first.print();
        System.out.println("Second: " + second);
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