package fawry.models;

import fawry.interfaces.Expirable;
import fawry.interfaces.Shippable;

public class ExpirableShippableProduct extends ExpirableProduct implements Shippable {
    private double weight;

    public ExpirableShippableProduct(String name, double price, int quantity, boolean expired, double weight) {
        super(name, price, quantity, expired);
        this.weight = weight;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getWeight() { return weight; }
}