package fawry.models;

import java.util.*;
import fawry.interfaces.Shippable;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity <= 0 || quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Invalid quantity for product: " + product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() { return items; }

    public boolean isEmpty() { return items.isEmpty(); }

    public double calculateSubtotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public List<Shippable> getShippableItems() {
        List<Shippable> list = new ArrayList<>();
        for (CartItem item : items) {
            if (item.getProduct() instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    list.add((Shippable) item.getProduct());
                }
            }
        }
        return list;
    }
}