package fawry.models;

import fawry.interfaces.Expirable;

public class ExpirableProduct extends Product implements Expirable {
    private boolean expired;

    public ExpirableProduct(String name, double price, int quantity, boolean expired) {
        super(name, price, quantity);
        this.expired = expired;
    }

    @Override
    public boolean isExpired() {
        return expired;
    }
}