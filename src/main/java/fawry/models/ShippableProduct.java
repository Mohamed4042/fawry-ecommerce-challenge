package fawry.models;

import fawry.interfaces.Shippable;

public class ShippableProduct extends Product implements Shippable {
    protected double weight; // in grams

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getWeight() { return weight; }
}